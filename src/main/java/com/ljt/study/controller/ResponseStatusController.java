package com.ljt.study.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJingTang
 * @date 2021-08-14 16:55
 */
@RestController
@RequestMapping("/responseStatus")
public class ResponseStatusController {

    @ResponseStatus(HttpStatus.IM_USED)
    @GetMapping
    public String status() {
        return "@ResponseStatus";
    }

}
