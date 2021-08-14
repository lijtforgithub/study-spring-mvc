package com.ljt.study.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiJingTang
 * @date 2021-08-13 09:09
 */
public class SimpleServletHandlerAdapterServlet extends HttpServlet {

    private static final long serialVersionUID = -5675571641849045765L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().write("SimpleServletHandlerAdapter");
    }

}
