package com.ljt.study.controller;

import com.ljt.study.vo.InitBinderVO;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author LiJingTang
 * @date 2021-08-13 14:37
 */
@RestController
@RequestMapping("/initBinder")
public class InitBinderController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }

    @GetMapping
    public InitBinderVO setAsText(Date date, LocalDate localDate) {
        InitBinderVO vo = InitBinderVO.builder().date(date).localDate(localDate).build();
        System.out.println(vo);

        return vo;
    }

}
