package com.ljt.study.advice;

import com.ljt.study.model.BaseModel;
import com.ljt.study.model.UserContext;
import com.ljt.study.model.UserContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:23
 */
@ControllerAdvice
public class UserContextRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return BaseModel.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (body instanceof BaseModel) {
            BaseModel model = (BaseModel) body;
            final UserContext context = UserContextHolder.get();
            if (Objects.nonNull(context)) {
                context.fillBaseModel(model);
            }
        }
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

}
