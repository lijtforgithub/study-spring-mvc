package com.ljt.study.advice;

import com.ljt.study.model.BaseModel;
import com.ljt.study.model.UserContext;
import com.ljt.study.model.UserContextHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.ServletRequest;
import java.util.Objects;

/**
 * @author LiJingTang
 * @date 2021-08-21 16:49
 */
@Component
public class UserContextBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanNamesForType(RequestMappingHandlerAdapter.class);
        for (String beanName : beanNames) {
            BeanDefinition bdf = beanFactory.getBeanDefinition(beanName);
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UserContextMethodArgumentResolver.class);
            ManagedList<Object> customArgumentResolvers = new ManagedList<>();
            customArgumentResolvers.add(builder.getBeanDefinition());

            /*
             * bdf.getPropertyValues().add("customArgumentResolvers", Collections.singletonList(new UserContextMethodArgumentResolver()))
             * bdf.getPropertyValues().add("customArgumentResolvers", Collections.singletonList(beanFactory.getBean(UserContextMethodArgumentResolver.class)))
             */
            bdf.getPropertyValues().add("customArgumentResolvers", customArgumentResolvers);
        }
    }

    private static class UserContextMethodArgumentResolver extends ModelAttributeMethodProcessor {

        public UserContextMethodArgumentResolver() {
            super(false);
        }

        @Override
        protected Object createAttribute(String attributeName, MethodParameter parameter, WebDataBinderFactory binderFactory, NativeWebRequest webRequest) throws Exception {
            Object obj = super.createAttribute(attributeName, parameter, binderFactory, webRequest);

            if (obj instanceof BaseModel) {
                BaseModel model = (BaseModel) obj;
                final UserContext context = UserContextHolder.get();
                if (Objects.nonNull(context)) {
                    UserContextHolder.fillModel(context, model);
                }
            }

            return obj;
        }

        @Override
        protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
            ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);
            Assert.state(servletRequest != null, "No ServletRequest");
            ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
            servletBinder.bind(servletRequest);
        }

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return BaseModel.class.isAssignableFrom(parameter.getParameterType());
        }
    }

}


