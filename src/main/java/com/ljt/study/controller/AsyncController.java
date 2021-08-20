package com.ljt.study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author LiJingTang
 * @date 2021-07-18 13:17
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    /**
     * 1. controller 返回 Callable
     * 2. spring 异步处理 将 Callable 提交到 TaskExecutor 使用一个隔离的线程执行
     * 3. DispatcherServlet 和所有的 Filter 退出web容器的线程 但是response 保持打开状态
     * 4. Callable 返回结果 springMvc 将请求重新派发给容器 恢复之前的处理
     * 5. 根据 Callable 返回的结果 springMvc 继续进行视图渲染流程
     * <p>
     * preHandle
     * 主线程
     * 副线程
     * preHandle
     * postHandle
     * afterCompletion
     * <p>
     * 异步拦截器
     * 1. 原生API：AsyncListener
     * 2. spring: AsyncHandlerInterceptor
     */
    @GetMapping(value = "/callable", produces = "text/plain; charset=UTF-8")
    public Callable<String> callable() {
        System.out.println("Callable 主线程进入");

        Callable<String> callable = () -> {
            sleep();
            System.out.println("Callable 处理中");
            return "久等了 Callable";
        };

        System.out.println("Callable 主线程退出");
        return callable;
    }

    @RequestMapping(value = "/webAsyncTask", produces = "text/plain; charset=UTF-8")
    public WebAsyncTask<String> webAsyncTask() {
        System.out.println("WebAsyncTask 主线程进入");

        WebAsyncTask<String> task = new WebAsyncTask<>(() -> {
            sleep();
            System.out.println("WebAsyncTask 处理中");
            return "久等了 WebAsyncTask";
        });

        System.out.println("WebAsyncTask 主线程退出");
        return task;
    }


    @GetMapping(value = "/deferredResult", produces = "text/plain; charset=UTF-8")
    public DeferredResult<String> deferredResult() {
        System.out.println("DeferredResult 主线程进入");

        DeferredResult<String> result = new DeferredResult<>();
        Executors.newSingleThreadExecutor().submit(() -> {
            sleep();
            System.out.println("DeferredResult 处理中");
            result.setResult("久等了 DeferredResult");
        });

        System.out.println("DeferredResult 主线程退出");
        return result;
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
