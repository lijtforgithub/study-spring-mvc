package com.ljt.study.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiJingTang
 * @date 2021-08-15 15:38
 */
public class AttributeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute("reqAttr", "AttributeInterceptor: @RequestAttribute");
        request.getSession().setAttribute("sessionAttr", "AttributeInterceptor: @SessionAttribute");

        return true;
    }
}
