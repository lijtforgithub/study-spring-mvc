package com.ljt.study.controller;

import com.ljt.study.exception.ResponseStatusException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @see HandlerExceptionResolver
 *
 * @author LiJingTang
 * @date 2021-08-18 14:08
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @SneakyThrows
    @GetMapping("/default")
    public String def() {
        System.out.println("DefaultHandlerExceptionResolver");
        throw new NoHandlerFoundException(null, null, null);
    }

    @GetMapping("/responseStatus")
    public String responseStatus() {
        System.out.println("ResponseStatusExceptionResolver");
        throw new ResponseStatusException("ResponseStatusException");
    }

    @GetMapping("/null")
    public String nullPoint() {
        String s = null;
        s.length();
        return null;
    }

    @ExceptionHandler(NullPointerException.class)
    private ModelAndView nullPointHandler(ModelAndView mav) {
        System.out.println("CustomExceptionHandlerExceptionResolver");
        mav.setViewName("error");
        mav.addObject("msg", "空指针");
        return mav;
    }

}
