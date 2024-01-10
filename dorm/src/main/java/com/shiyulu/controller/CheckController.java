package com.shiyulu.controller;

import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.pojo.PageBean;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.CheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chr")
public class CheckController {

    @Autowired
    private CheckService checkService;

    //查询学生的全部情况
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        CheckRecord chr = checkService.getById(id);
        return Result.success(chr);
    }

    @GetMapping("/getAll")
    public Result list(){
        List<CheckRecord> checkList =  checkService.list();
        return Result.success(checkList);
    }

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       String studentNumber,String dormitoryNumber,Integer dailyScore,Integer monthlyScore){
        //调用service分页查询
        PageBean pageBean = checkService.page(page,pageSize, studentNumber,dormitoryNumber,dailyScore,monthlyScore);
        return Result.success(pageBean);
    }

    //将扣分原因与被扣分数上传
    @PutMapping
    public Result update(@RequestBody CheckRecord chr){
        //log.info("更新学生信息 : {}", chr);
        checkService.update(chr);
        //System.out.println("aaa");
        return Result.success();
    }

    @PutMapping("/update1")
    public Result update1(@RequestBody CheckRecord chr){
        //log.info("更新学生信息 : {}", chr);
        checkService.update1(chr);
        //System.out.println("aaa");
        return Result.success();
    }

    @GetMapping("/Ranktop")
    public Result top (){
        List<CheckRecord> checkList =  checkService.listtop();
        return Result.success(checkList);
    }

    @GetMapping("/Rankbottom")
    public Result bottom (){
        List<CheckRecord> checkList =  checkService.listbottom();
        return Result.success(checkList);
    }

}
