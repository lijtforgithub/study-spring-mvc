package com.ljt.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiJingTang
 * @date 2021-08-12 14:26
 */
public class BeanNameUrlHandlerMappingController1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("BeanNameUrlHandlerMapping : implements Controller");

        return null;
    }

}
