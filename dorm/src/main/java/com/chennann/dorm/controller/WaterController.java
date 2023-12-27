package com.chennann.dorm.controller;


import com.chennann.dorm.pojo.Result;
import com.chennann.dorm.pojo.Student;
import com.chennann.dorm.pojo.WaterOrder;
import com.chennann.dorm.service.StudentService;
import com.chennann.dorm.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/order")
    public Result<String> order (@RequestBody @Validated(WaterOrder.Add.class) WaterOrder waterOrder) throws NoSuchAlgorithmException {

        //验证学生和宿舍
        Student student = studentService.findStudentByIdAndDorm(waterOrder.getStudentId(), waterOrder.getDormNumber());
        if (student == null) {
            return Result.error("找不到指定学生或宿舍");
        }


        String orderNumber = waterService.order(waterOrder);

        return Result.success(orderNumber);
    }

    @GetMapping("/list")
    public Result<List<WaterOrder>> list (
            @RequestParam(required = false)Integer waterStationId,
            @RequestParam(required = false)Integer state
    ) {
        List<WaterOrder> WOlist = waterService.listWaterOrder(waterStationId, state);

        return Result.success(WOlist);
    }

    @PostMapping("/changestate")
    public Result changeState (@RequestBody @Validated(WaterOrder.Update.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return Result.error("找不到指定订单");
        }
        waterService.changeState(waterOrder);
        return Result.success();
    }

    @PostMapping("/cancel")
    public Result cancel (@RequestBody @Validated(WaterOrder.Cancel.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return Result.error("找不到指定订单");
        }
        waterService.cancel(waterOrder);
        return Result.success();
    }
}
