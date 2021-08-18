package com.ljt.study.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;

/**
 * @author LiJingTang
 * @date 2021-08-16 14:47
 */
@Data
public class JsonViewVO implements Serializable {

    public interface SimpleView {}
    public interface DetailView extends SimpleView {}

    @JsonView(SimpleView.class)
    private Integer id;
    @JsonView(SimpleView.class)
    private String name;

    @JsonView(DetailView.class)
    private String address;

}
