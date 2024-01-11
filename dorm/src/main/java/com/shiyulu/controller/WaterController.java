package com.shiyulu.controller;


import com.shiyulu.pojo.*;
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

    @GetMapping("/listbystation")
    public ResultChen<PageBeanChen<WaterOrder>> listbystation (
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false)Integer waterStationId,
            @RequestParam(required = false)Integer state,
            @RequestParam(required = false)Integer today
    ) {
        PageBeanChen<WaterOrder> WOlist = waterService.listWaterOrder(pageNum, pageSize, waterStationId, state, today);

        return ResultChen.success(WOlist);
    }

    @PostMapping("/changestate")
    public ResultChen changeState (@RequestBody @Validated(WaterOrder.Update.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return ResultChen.error("找不到指定订单");
        }

        if ("未接收".equals(WO.getWaterOrderStatus())) waterOrder.setWaterOrderStatus("运送中");
        else if ("运送中".equals(WO.getWaterOrderStatus())) waterOrder.setWaterOrderStatus("已完成");
        else {
            return ResultChen.error("订单状态错误");
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
        if ("未接收".equals(WO.getWaterOrderStatus())) {
            waterService.cancel(waterOrder);
            return ResultChen.success();
        }
        if ("已取消".equals(WO.getWaterOrderStatus())) {
            return ResultChen.error("此订单已取消");
        }
        return ResultChen.error("订单执行中，无法取消");

    }

    @GetMapping("/listbystudent")
    public ResultChen<PageBeanChen<WaterOrder>> listByStudent (
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = true) String dormNumber,
            @RequestParam(required = false) Integer status
    ) {
        PageBeanChen<WaterOrder> WOlist = waterService.listWaterOrderByDorm(pageNum, pageSize, dormNumber, status);

        return ResultChen.success(WOlist);
    }

    @GetMapping("/listbill")
    public ResultChen<PageBeanChen<WaterBill>> listBill (
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = true) String dormNumber,
            @RequestParam(required = false) Integer status
    ) {
        PageBeanChen<WaterBill> waterBillList = waterService.listBill(pageNum, pageSize, dormNumber, status);
        return ResultChen.success(waterBillList);
    }



    @GetMapping("/monthlydata")
    public ResultChen<MonthlyWaterData> monthlyData (@RequestParam String dormNumber) {

        MonthlyWaterData monthlyWaterData = waterService.generateMonthlyDataByDormNumber(dormNumber);

        return ResultChen.success(monthlyWaterData);

    }
}
