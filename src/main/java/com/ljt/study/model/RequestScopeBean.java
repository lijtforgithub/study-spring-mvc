package com.ljt.study.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author LiJingTang
 * @date 2021-08-15 13:36
 */
@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RequestScopeBean {
}
