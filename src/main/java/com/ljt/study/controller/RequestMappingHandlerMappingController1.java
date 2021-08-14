package com.ljt.study.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @author LiJingTang
 * @date 2021-08-12 14:42
 */
@Component
@RequestMapping
public class RequestMappingHandlerMappingController1 {

    @GetMapping("/requestMapping-1")
    @ResponseBody
    public String index() {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "RequestMappingHandlerMappingController1";
    }

}
