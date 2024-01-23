package com.shiyulu.service;

import com.shiyulu.pojo.WaterBill;
import com.shiyulu.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class ScheduleService {

    @Autowired
    private WaterService waterService;

    @Scheduled(cron = "0 0 0 L * ?")
    public void monthlyBillGenerator () throws NoSuchAlgorithmException {
        System.out.println("开始生成月度账单");
        List<WaterBill> waterBillList = new ArrayList<>();
        waterBillList = waterService.monthlyBillGenerator();

        //生成账单编号
        for (WaterBill waterBill : waterBillList) {
            waterBill.setWaterBillNumber(NumberUtil.generateShortOrderNumber());
            waterBill.setWaterBillStatus("未缴费");
        }

        waterService.insertBills(waterBillList);
    }

}
