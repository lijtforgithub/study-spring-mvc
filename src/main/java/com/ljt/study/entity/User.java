package com.ljt.study.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author LiJingTang
 * @date 2021-08-16 10:07
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 8342017815745568353L;

    @NotBlank(message = "姓名为空")
    private String name;
    private int age;
    private String gender;

}
