package com.ljt.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author LiJingTang
 * @date 2021-08-18 16:08
 */
@ResponseStatus(HttpStatus.MULTI_STATUS)
public class ResponseStatusException extends RuntimeException {

    private static final long serialVersionUID = 6172157833428815808L;

    public ResponseStatusException(String message) {
        super(message);
    }

}
