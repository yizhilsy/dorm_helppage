package com.shiyulu.controller;

import com.shiyulu.pojo.*;
import com.shiyulu.service.CheckService;
import com.shiyulu.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private CheckService checkService;

    //查询学生的全部情况

//    @GetMapping("/getAll")
//    public Result list(){
//        List<CheckRecord> checkList =  checkService.list();
//        return Result.success(checkList);
//    }

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "5") Integer pageSize,
//                       String studentNumber,String dormitoryNumber,Integer dailyScore){
//        //调用service分页查询
//        PageBean pageBean = checkService.page(page,pageSize, studentNumber,dormitoryNumber,dailyScore);
//        return Result.success(pageBean);
//    }
//
//    //将扣分原因与被扣分数上传
//    ///扣分
//    @PutMapping
//    public Result update(@RequestBody CheckRecord chr){
//        //log.info("更新学生信息 : {}", chr);
//        checkService.update(chr);
//        //System.out.println("aaa");
//        return Result.success();
//    }
//
//    //满分
//    @PutMapping("/update1")
//    public Result update1(@RequestBody CheckRecord chr){
//        //log.info("更新学生信息 : {}", chr);
//        checkService.update1(chr);
//        //System.out.println("aaa");
//        return Result.success();
//    }
//
//    @GetMapping("/Ranktop")
//    public Result top (){
//        List<CheckRecord> checkList =  checkService.listtop();
//        return Result.success(checkList);
//    }
//
//    @GetMapping("/Rankbottom")
//    public Result bottom (){
//        List<CheckRecord> checkList =  checkService.listbottom();
//        return Result.success(checkList);
//    }

    @PostMapping("/add")
    public ResultChen add (@RequestBody CheckReceived checkReceived) {

        //检查总分是否超过10分
        if (
                checkReceived.getBalcony() +
                checkReceived.getDesk() +
                checkReceived.getRubbish() +
                checkReceived.getFloor() +
                checkReceived.getQuilt() > 10) {
            return ResultChen.error("扣分总和不能超过10分");
        }

        //检查当日是否检查过
        Check check = checkService.findCheckByTimeAndNumber(checkReceived.getCheckTime(),checkReceived.getStudentNumber());
        if (check != null) {
            return ResultChen.error("当日已检查过");
        }
        System.out.println(checkReceived);
        checkService.add(checkReceived);
        return ResultChen.success();
    }

    @GetMapping("/dailyscoreboard")
    public ResultChen<PageBeanChen<DailyScoreBoardItem>> dailyScoreBoard (
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String dateStr
    ) {

        LocalDateTime date = null;

        if (dateStr != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                date = LocalDateTime.parse(dateStr, formatter);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        }

        PageBeanChen<DailyScoreBoardItem> pd= checkService.dailyScoreBoard(pageNum,pageSize, date);

        return ResultChen.success(pd);
    }

    //列出扣分记录
    @GetMapping("/list")
    public ResultChen<PageBeanChen<Check>> checkList (
            Integer pageNum,
            Integer pageSize,
            String studentNumber
    ) {
        PageBeanChen<Check> pd= checkService.checkList(pageNum,pageSize, studentNumber);

        return ResultChen.success(pd);
    }

//    @GetMapping("/dormscore")
//    public ResultChen<List<>> dormScore () {
//
//    }
//
//    @GetMapping("/studentscore")
//    public ResultChen<List<>> dormScore () {
//
//    }


    @PostMapping("/appeal")
    public ResultChen appeal (@RequestBody Appeal appeal) {

        Check check = checkService.findCheckById(appeal.getCheckId());

        if (check == null) {
            return ResultChen.error("该记录不存在");
        }
        if (!"已扣分".equals(check.getStatus())) {
            return ResultChen.error("扣分状态不正确，不能申诉");
        }
        checkService.appeal(appeal);

        return ResultChen.success();
    }

    //列出申诉记录
    @GetMapping("/appeal/list")
    public ResultChen<PageBeanChen<Check>> appealList (
            Integer pageNum,
            Integer pageSize,
            String checkerUserName
    ) {
        PageBeanChen<Check> pd= checkService.appeakList(pageNum,pageSize, checkerUserName);

        return ResultChen.success(pd);
    }

    @PostMapping("/appeal/verifyYes")
    public ResultChen appealVerifyYes (@RequestBody Check check) {
        Check ck = checkService.findCheckById(check.getId());
        if (ck == null) {
            return ResultChen.error("该记录不存在");
        }
        if (!"申诉中".equals(ck.getStatus())) {
            return ResultChen.error("申诉状态不正确，不能审核");
        }

        checkService.appealVerifyYes(check);
        return ResultChen.success();
    }

    @PostMapping("/appeal/verifyNo")
    public ResultChen appealVerifyNo (@RequestBody Check check) {
        Check ck = checkService.findCheckById(check.getId());
        if (ck == null) {
            return ResultChen.error("该记录不存在");
        }
        if (!"申诉中".equals(ck.getStatus())) {
            return ResultChen.error("申诉状态不正确，不能审核");
        }

        checkService.appealVerifyNo(check);

        return ResultChen.success();

    }

    //列出学生申诉状态
    @GetMapping("/appeal/status")
    public ResultChen<PageBeanChen<Check>> appealStatus (
            Integer pageNum,
            Integer pageSize,
            String studentNumber
    ) {
        PageBeanChen<Check> pd= checkService.appeakStatus(pageNum,pageSize, studentNumber);

        return ResultChen.success(pd);
    }

    @GetMapping("/rank/top")
    public ResultChen<List<DailyScoreBoardItem>> rankTop () {

        List<DailyScoreBoardItem> pd= checkService.rankTop();

        return ResultChen.success(pd);
    }

    @GetMapping("/rank/bottom")
    public ResultChen<List<DailyScoreBoardItem>> rankBottom () {

        List<DailyScoreBoardItem> pd= checkService.rankBottom();

        return ResultChen.success(pd);
    }
}
