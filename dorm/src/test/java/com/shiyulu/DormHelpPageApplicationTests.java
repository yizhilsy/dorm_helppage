package com.shiyulu;

import com.shiyulu.mapper.WaterMapper;
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

    @Autowired
    private WaterMapper waterMapper;
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

    @Test
    void test() {
//        Integer waterStationId = 1;
//
//        Integer finished = waterService.countFinishedByWaterStationId(waterStationId);
//        Integer delivering = waterService.countDeliveringByWaterStationId(waterStationId);
//        Integer unconfirmed = waterService.countUnconfirmedByWaterStationId(waterStationId);
//        Integer canceled = waterService.countCanceledByWaterStationId(waterStationId);
//
//
//        System.out.println(finished);
//        System.out.println(delivering);
//        System.out.println(unconfirmed);
//        System.out.println(canceled);

        System.out.println(waterMapper.countUnconfirmedByWaterStationId(1));
    }

}
