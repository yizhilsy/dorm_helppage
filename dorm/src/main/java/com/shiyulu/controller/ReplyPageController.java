package com.shiyulu.controller;

import com.shiyulu.pojo.HelpPage;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.ReplyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        log.info("打开主帖的子帖: 主帖的id号{}",id);
        List<ReplyPage> replyPageList = replyPageService.listByMainPageId(id);
        return Result.success(replyPageList);
    }

    @PostMapping("/read/addreply/{id}")
    public Result saveReplyPageByMainPageId(@RequestBody ReplyPage replyPage,@PathVariable Integer id){
        log.info("为主帖：{}添加回复帖：{}",id,replyPage);
        replyPageService.save(id,replyPage);
        return Result.success();

    }
}
