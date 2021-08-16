package com.ljt.study.advice;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @date 2021-08-16 10:39
 */
@Data
public class RequestAdvice implements Serializable {

    private static final long serialVersionUID = -4136037812558734591L;

    private String msg;

}
