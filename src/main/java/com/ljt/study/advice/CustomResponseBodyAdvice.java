package com.ljt.study.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author LiJingTang
 * @date 2021-08-15 12:06
 */
@ControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice<ResponseAdvice> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return ResponseAdvice.class == returnType.getGenericParameterType();
    }

    @Override
    public ResponseAdvice beforeBodyWrite(ResponseAdvice body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Objects.requireNonNull(body).setMsg("加密数据：" + body.getMsg());

        return body;
    }

}
