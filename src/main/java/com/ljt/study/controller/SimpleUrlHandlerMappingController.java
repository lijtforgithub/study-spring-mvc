package com.ljt.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiJingTang
 * @date 2021-08-15 19:50
 */
public class SimpleUrlHandlerMappingController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.getWriter().write("SimpleUrlHandlerMapping : extends AbstractController");

        return null;
    }

}
