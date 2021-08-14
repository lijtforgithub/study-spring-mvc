package com.ljt.study.controller;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiJingTang
 * @date 2021-08-11 16:07
 */
public class BeanNameUrlHandlerMappingController2 implements HttpRequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("BeanNameUrlHandlerMapping : implements HttpRequestHandler");
    }

}
