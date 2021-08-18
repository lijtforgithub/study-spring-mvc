package com.ljt.study.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.ljt.study.vo.JsonViewVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJingTang
 * @date 2021-08-16 14:46
 */
@RestController
@RequestMapping("/jsonView")
public class JsonViewController {

    @JsonView(JsonViewVO.SimpleView.class)
    @GetMapping("/simple")
    public JsonViewVO simple() {
        return getView();
    }

    @JsonView(JsonViewVO.DetailView.class)
    @GetMapping("/detail")
    public JsonViewVO detail() {
        return getView();
    }

    private JsonViewVO getView() {
        JsonViewVO vo = new JsonViewVO();
        vo.setId(1);
        vo.setName("@JsonView");
        vo.setAddress("乌衣巷");

        return vo;
    }

}
