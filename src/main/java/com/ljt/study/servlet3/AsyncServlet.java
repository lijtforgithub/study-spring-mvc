package com.ljt.study.servlet3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author LiJingTang
 * @date 2021-07-18 13:11
 */
@WebServlet(value = "/async/servlet", asyncSupported = true)
class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = -8640546843844346413L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

        AsyncContext context = req.startAsync();
        context.addListener(new MyAsyncListener());

        context.start(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                req.getAsyncContext().complete();
                ServletResponse response = req.getAsyncContext().getResponse();

                try {
                    response.getWriter().print("异步处理");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

class MyAsyncListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent asyncEvent) {
        System.out.println("onComplete");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) {
        System.out.println("onTimeout");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) {
        System.out.println("onError");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) {
        System.out.println("onStartAsync");
    }

}
