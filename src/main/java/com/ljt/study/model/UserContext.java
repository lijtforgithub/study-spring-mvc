package com.ljt.study.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:43
 */
@Data
@Accessors(chain = true)
public class UserContext implements Serializable {

    private static final long serialVersionUID = 4943871404963739925L;

    private Long id;
    private String name;
    private String mobile;

}
