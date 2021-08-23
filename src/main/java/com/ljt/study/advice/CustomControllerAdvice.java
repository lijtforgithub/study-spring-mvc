package com.ljt.study.advice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author LiJingTang
 * @date 2021-08-15 10:57
 */
@ControllerAdvice
public class CustomControllerAdvice {

    @InitBinder
    public void initBinderLocalDate(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
    }

    @InitBinder
    public void initBinderString(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(StringUtils.trimToNull(text));
            }
        });
    }

    @ModelAttribute("adviceModelAttr")
    public String modelAttribute() {
       return "CustomControllerAdvice: @ModelAttribute";
    }

}

class LocalDateEditor extends PropertyEditorSupport {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Override
    public String getAsText() {
        System.out.println("getAsText 进来了");

        final Object value = getValue();
        if (Objects.nonNull(value)) {
            LocalDate localDate = (LocalDate) value;
            return localDate.format(DATE_TIME_FORMATTER);
        }

        return null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isBlank(text)) {
            setValue(null);
        } else {
            LocalDate localDate = LocalDate.parse(text, DATE_TIME_FORMATTER);
            setValue(localDate);
        }
    }

}
