package com.ljt.study.controller;

import com.ljt.study.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author LiJingTang
 * @date 2021-08-15 18:33
 */
@RestController
@RequestMapping("/bindingResult")
public class BindingResultController {

    @GetMapping
    public String user(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
        }
        return "BindingResult";
    }

}
