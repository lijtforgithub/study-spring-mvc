package com.ljt.study.controller;

import com.ljt.study.model.Record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJingTang
 * @date 2021-08-21 13:32
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @GetMapping("/body")
    public Record body(@RequestBody Record record) {
        System.out.println(record);
        record.setRemark("已处理：" + record.getRemark());
        return record;
    }

    @GetMapping("/param")
    public Record param(Record record) {
        System.out.println(record);
        record.setRemark("已处理：" + record.getRemark());
        return record;
    }

}

