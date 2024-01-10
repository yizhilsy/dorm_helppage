package com.shiyulu.controller;

import com.shiyulu.pojo.Avator;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.AvatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/avator")
public class AvatorController {
    @Autowired
    private AvatorService avatorService;

    @GetMapping("/{username}")
    public Result getAvatorById(@PathVariable String username) {
        log.info("根据用户名：{}返回该用户的头像",username);
        Avator avator = avatorService.getAvatorById(username);
        return Result.success(avator);
    }

}
