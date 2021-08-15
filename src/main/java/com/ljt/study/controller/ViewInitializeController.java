package com.ljt.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LiJingTang
 * @date 2021-08-15 12:39
 */
@Controller
@RequestMapping("/viewInitialize")
public class ViewInitializeController {

    @GetMapping
    public String view() {
        return "viewInitialize";
    }

}
