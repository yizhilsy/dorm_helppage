package com.shiyulu.controller;

import com.shiyulu.pojo.HelpPage;
import com.shiyulu.pojo.PageBean;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.HelpPageService;
import com.shiyulu.service.ReplyPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/square")
public class HelpPageController {
    @Autowired
    private HelpPageService helpPageService;

    @Autowired
    private ReplyPageService replyPageService;
    /**
     * 查询全部帖子
     */
    @GetMapping
    public Result list(){
        log.info("查询全部互助帖数据");
        List<HelpPage> helpPageList = helpPageService.list();
        return Result.success(helpPageList);
    }

    /**
     * 根据筛选条件分页查询帖子
     */
    @GetMapping("/query")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       Integer typeId,
                       @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数: {},{},{},{},{}",page,pageSize,typeId,begin,end);
        PageBean pageBean = helpPageService.page(page,pageSize,typeId,begin,end);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result save(@RequestBody HelpPage helpPage){
        log.info("新增帖子: {}",helpPage);
        helpPageService.save(helpPage);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除帖子, ids:{}",ids);
        helpPageService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询帖子信息, id:{}",id);
        HelpPage helpPage = helpPageService.getById(id);
        return Result.success(helpPage);
    }

    @PutMapping
    public Result update(@RequestBody HelpPage helpPage){
        log.info("更新帖子信息: {}",helpPage);
        helpPageService.update(helpPage);
        return Result.success();
    }

//    @GetMapping("/read/{id}")
//    public Result readById(@PathVariable Integer id){
//        log.info("阅读指定的帖子, id: {}",id);
//        HelpPage helpPage = helpPageService.getById(id);
//        List<ReplyPage> replyPageList = replyPageService.listByMainPageId(id);
//        Map<HelpPage,List<ReplyPage>> ans = new HashMap<>();
//        ans.put(helpPage,replyPageList);
//        return Result.success(ans);
//    }

    //根据用户名查询自己发的帖子
    @GetMapping("/mypage/{username}")
    public Result listByUsername(@PathVariable String username){
        log.info("根据用户名返回该用户发的所有帖子：username{}",username);
        List<HelpPage> helpPageList = helpPageService.listByUsername(username);
        return Result.success(helpPageList);
    }


}
