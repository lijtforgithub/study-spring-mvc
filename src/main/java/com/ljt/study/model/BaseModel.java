package com.ljt.study.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:21
 */
@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 719200293625279556L;

    private Long creatorId;
    private String creator;
    private Long createTime;
    private Long updaterId;
    private String updater;
    private Long updateTime;

}
