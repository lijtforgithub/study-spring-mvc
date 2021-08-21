package com.ljt.study.controller;

import com.ljt.study.model.RequestScopeBean;
import com.ljt.study.model.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author LiJingTang
 * @date 2021-08-15 13:43
 */
@RestController
@RequestMapping("/scope")
public class ScopeController {

    @Autowired
    private WebApplicationContext applicationContext;

    @GetMapping("/request")
    public String request() {
        return applicationContext.getBean(RequestScopeBean.class).toString();
    }

    @GetMapping("/session")
    public String session() {
        return applicationContext.getBean(SessionScopeBean.class).toString();
    }

}
