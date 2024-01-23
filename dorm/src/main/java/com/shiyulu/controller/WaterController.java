package com.shiyulu.controller;


import com.shiyulu.anno.RequireRole;
import com.shiyulu.pojo.*;
import com.shiyulu.service.StudentService;
import com.shiyulu.service.WaterService;
import com.shiyulu.utils.NumberUtil;
import com.shiyulu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.shiyulu.utils.Constants.*;

@RestController
@RequestMapping("/water")
public class WaterController {

    @Autowired
    private WaterService waterService;

    @Autowired
    private StudentService studentService;

    @RequireRole({MANAGER, STUDENT})
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

    @RequireRole({MANAGER, WATER_STATION})
    @PostMapping("/changestate")
    public ResultChen changeState (@RequestBody @Validated(WaterOrder.Update.class) WaterOrder waterOrder) {

        //验证订单信息
        WaterOrder WO = waterService.findOrderByIdAndNumber(waterOrder.getWaterOrderId(), waterOrder.getWaterOrderNumber());
        if (WO == null) {
            return ResultChen.error("找不到指定订单");
        }

        if ("未接收".equals(WO.getWaterOrderStatus())) waterOrder.setWaterOrderStatus("运送中");
        else if ("运送中".equals(WO.getWaterOrderStatus())) waterOrder.setWaterOrderStatus("未缴费");
        else {
            return ResultChen.error("订单状态错误");
        }

        waterService.changeState(waterOrder);
        return ResultChen.success();
    }

    @RequireRole({MANAGER, STUDENT})
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

    @GetMapping("/waterstationInfo")
    public ResultChen<WaterStation> waterStationInfo () {

        Map<String, Object> map= ThreadLocalUtil.get();

        WaterStation waterStation = waterService.findWaterStationByUsername((String) map.get("username"));

        return ResultChen.success(waterStation);

    }

    @GetMapping("/waterstationMonthlyData")
    public ResultChen waterstationMonthlyData (@RequestParam Integer waterStationId) {

        WaterStationMonthlyData waterStationMonthlyData = new WaterStationMonthlyData();

        Integer finished = waterService.countFinishedByWaterStationId(waterStationId);
        Integer delivering = waterService.countDeliveringByWaterStationId(waterStationId);
        Integer unconfirmed = waterService.countUnconfirmedByWaterStationId(waterStationId);
        Integer canceled = waterService.countCanceledByWaterStationId(waterStationId);

        waterStationMonthlyData.setWaterStationId(waterStationId);

        waterStationMonthlyData.setFinished(finished == null ? 0 : finished);
        waterStationMonthlyData.setDelivering(delivering == null ? 0 : delivering);
        waterStationMonthlyData.setUnconfirmed(unconfirmed == null ? 0 : unconfirmed);
        waterStationMonthlyData.setCanceled(canceled == null ? 0 : canceled);

        return ResultChen.success(waterStationMonthlyData);
    }

    @GetMapping("/liststations")
    public ResultChen<PageBeanChen<WaterStation>> listStations (
            Integer pageNum,
            Integer pageSize
    ) {
        PageBeanChen<WaterStation> waterStationList = waterService.listWaterStation(pageNum, pageSize);
        return ResultChen.success(waterStationList);
    }

    @PostMapping("/waterbillGenerate")
    public ResultChen waterbillGenerate () throws NoSuchAlgorithmException {
        System.out.println("开始生成月度账单");
        List<WaterBill> waterBillList = new ArrayList<>();
        waterBillList = waterService.monthlyBillGenerator();


        //生成账单编号
        for (WaterBill waterBill : waterBillList) {
            waterBill.setWaterBillNumber(NumberUtil.generateShortOrderNumber());
            waterBill.setWaterBillStatus("未缴费");
        }

        System.out.println(waterBillList);
        waterService.insertBills(waterBillList);

        return ResultChen.success();
    }
    @RequireRole({MANAGER, STUDENT})
    @PostMapping("/pay")
    public ResultChen pay (@RequestBody WaterBill waterBill) {

        WaterBill wb = waterService.findBill(waterBill);
        if (wb == null) {
            return ResultChen.error("找不到指定账单");
        }

        if ("已缴费".equals(wb.getWaterBillStatus())) {
            return ResultChen.error("此账单已缴费");
        }

        waterService.pay(waterBill);

        waterService.updateOrderStatus(waterBill);

        return ResultChen.success();
    }

    @GetMapping("/getOrderDetail")
    public ResultChen<WaterOrder> getOrderDetail (@RequestParam Integer waterOrderId, @RequestParam String waterOrderNumber) {

        WaterOrder w = waterService.getOrderDetail(waterOrderId, waterOrderNumber);

        if (w == null) {
            return ResultChen.error("找不到订单");
        }
        return ResultChen.success(w);

    }
}
