package com.ljt.study.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
 * @author LiJingTang
 * @date 2021-08-15 11:56
 */
@ControllerAdvice
public class CustomRequestBodyAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return RequestAdvice.class == methodParameter.getGenericParameterType();
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        RequestAdvice advice = (RequestAdvice) body;
        advice.setMsg("解密数据：" + advice.getMsg());
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

}
