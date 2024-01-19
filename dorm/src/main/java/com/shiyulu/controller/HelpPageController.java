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

    // 查询主帖号为id的帖子的点赞数
    @GetMapping("/like/{id}")
    public Result getLikeNumById(@PathVariable Integer id){
        log.info("根据主帖号查询该帖的点赞数，id：{}",id);
        Integer likeNum = helpPageService.getLikeNumById(id);
        return Result.success(likeNum);
    }

    // 查询谁喜欢了主帖号为id的帖子，返回用户id的集合
    @GetMapping("/like/who/{id}")
    public Result getLikeUserById(@PathVariable Integer id){
        log.info("根据主帖号查询喜欢该帖的用户的用户id，id：{}",id);
        List<Integer> likeUsers = helpPageService.getLikeUserById(id);
        return Result.success(likeUsers);
    }

    // 用户号为u_id的用户喜欢了帖子号为id的帖子
    @GetMapping("/addlike/{id}/{u_id}")
    public Result addLike(@PathVariable Integer id,@PathVariable Integer u_id){
        log.info("用户id为：{}对主贴号为：{}的主贴添加喜欢",u_id,id);
        helpPageService.addLike(id,u_id);
        return Result.success();
    }

    // 用户号为u_id的用户取消喜欢了帖子号为id的帖子
    @GetMapping("/cancellike/{id}/{u_id}")
    public Result cancelLike(@PathVariable Integer id, @PathVariable Integer u_id){
        log.info("用户id为：{}对主贴号为：{}的主贴取消喜欢",u_id,id);
        helpPageService.cancelLike(id,u_id);
        return Result.success();
    }

    // 查询点赞数最高的5个帖子
    @GetMapping("/hotest5")
    public Result hotest5(){
        log.info("查询点赞数最高的5个帖子");
        List<HelpPage> hotesthelppages = helpPageService.hotest5();
        return Result.success(hotesthelppages);
    }

    @GetMapping("/mylike/{uid}")
    public Result myLikePages(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              Integer typeId,
                              @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin,
                              @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                              @PathVariable Integer uid){
        log.info("查询用户id为:{}的用户喜欢的帖子",uid);
        PageBean pageBean = helpPageService.myLikePages(page,pageSize,typeId,begin,end,uid);
        return Result.success(pageBean);
    }

}
