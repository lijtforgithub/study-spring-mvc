package com.ljt.study.controller;

import com.ljt.study.advice.RequestAdvice;
import com.ljt.study.advice.ResponseAdvice;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiJingTang
 * @date 2021-08-16 10:48
 */
@RestController
@RequestMapping("/advice")
public class RequestResponseAdviceController {

    @GetMapping("/response")
    public ResponseAdvice response() {
        ResponseAdvice advice = new ResponseAdvice();
        advice.setMsg("ResponseBodyAdvice");
        return advice;
    }

    @GetMapping("/request")
    public RequestAdvice request(@RequestBody RequestAdvice reqAdvice) {
        return reqAdvice;
    }

}
