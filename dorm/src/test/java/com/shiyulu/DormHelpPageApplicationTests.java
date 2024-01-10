package com.shiyulu;

import com.shiyulu.pojo.WaterBill;
import com.shiyulu.service.WaterService;
import com.shiyulu.utils.NumberUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DormHelpPageApplicationTests {
    @Autowired
    private WaterService waterService;
    @Test
    void contextLoads() throws NoSuchAlgorithmException {
        List<WaterBill> waterBillList = new ArrayList<>();
        waterBillList = waterService.monthlyBillGenerator();

        //生成账单编号
        for (WaterBill waterBill : waterBillList) {
            System.out.println(waterBill);
            waterBill.setWaterBillNumber(NumberUtil.generateShortOrderNumber());
            waterBill.setWaterBillStatus("未缴费");
        }

        waterService.insertBills(waterBillList);
    }

}
