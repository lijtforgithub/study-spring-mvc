package com.ljt.study.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author LiJingTang
 * @date 2021-08-15 14:38
 */
@Data
@Builder
public class InitBinderVO implements Serializable {

    private static final long serialVersionUID = -9143088350324771656L;

    private Date date;
    private LocalDate localDate;

}
