package com.ljt.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiJingTang
 * @date 2021-08-12 14:42
 */
@Controller
@RequestMapping("requestMapping-2")
public class RequestMappingHandlerMappingController2 {

    @GetMapping()
    @ResponseBody
    public String index() {
        return "RequestMappingHandlerMappingController2";
    }

}
