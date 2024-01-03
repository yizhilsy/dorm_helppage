package com.shiyulu.controller;

import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.ReplyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/square")
public class ReplyPageController {
    @Autowired
    private ReplyPageService replyPageService;

    //根据主帖号返回回复帖
    @GetMapping("/read/{id}")
    public Result listByMainPageId(@PathVariable Integer id){
        log.info("打开主帖并查看子帖: id号{}",id);
        List<ReplyPage> replyPageList = replyPageService.listByMainPageId(id);
        return Result.success(replyPageList);
    }
}
