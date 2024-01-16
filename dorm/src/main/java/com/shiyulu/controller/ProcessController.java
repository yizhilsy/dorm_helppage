package com.shiyulu.controller;

import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.pojo.Result;
import com.shiyulu.service.ProcessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pro")
public class ProcessController {

    @Autowired
    private ProcessService processService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String dailyPenaltyImageUrl ,String student_appeal_reason){
//        //调用service分页查询
//        PageBean pageBean = processService.page(page,pageSize,dailyPenaltyImageUrl,student_appeal_reason);
//        return Result.success(pageBean);
//    }

//    @GetMapping("/getAll")
//    public Result list(){
//        List<CheckRecord> processList =  processService.list();
//        return Result.success(processList);
//    }
//
//    @PutMapping
//    public Result process(@RequestBody CheckRecord chr){
//        processService.process(chr);
//        return Result.success();
//    }
//
//    @GetMapping("/img")
//    public Result getimg(@RequestBody CheckRecord chr){
//        String img =  processService.getimg(chr);
//        return Result.success(img);
//    }
//
//    @PutMapping("/dis")
//    public Result process2(@RequestBody CheckRecord chr){
//        processService.process2(chr);
//        return Result.success();
//    }

}
