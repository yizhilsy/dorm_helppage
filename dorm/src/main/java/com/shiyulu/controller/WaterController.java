package com.shiyulu.controller;


import com.shiyulu.pojo.ResultChen;
import com.shiyulu.pojo.Student;
import com.shiyulu.pojo.WaterOrder;
import com.shiyulu.service.StudentService;
import com.shiyulu.service.WaterService;
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
    public ResultChen<String> order (@RequestBody @Validated(WaterOrder.Add.class) WaterOrder waterOrder) throws NoSuchAlgorithmException {

        //验证学生和宿舍
        Student student = studentService.findStudentByIdAndDorm(waterOrder.getStudentId(), waterOrder.getDormNumber());
        if (student == null) {
            return ResultChen.error("找不到指定学生或宿舍");
        }


        String orderNumber = waterService.order(waterOrder);

        return ResultChen.success(orderNumber);
    }

    @GetMapping("/list")
    public ResultChen<List<WaterOrder>> list (
            @RequestParam(required = false)Integer waterStationId,
            @RequestParam(required = false)Integer state
    ) {
        List<WaterOrder> WOlist = waterService.listWaterOrder(waterStationId, state);

        //return ResultChen.success(WOlist);
        return ResultChen.success();
    }

    @PostMapping("/changestate")
    public ResultChen changeState (@RequestBody @Validated(WaterOrder.Update.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return ResultChen.error("找不到指定订单");
        }
        waterService.changeState(waterOrder);
        return ResultChen.success();
    }

    @PostMapping("/cancel")
    public ResultChen cancel (@RequestBody @Validated(WaterOrder.Cancel.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return ResultChen.error("找不到指定订单");
        }
        waterService.cancel(waterOrder);
        return ResultChen.success();
    }
}
