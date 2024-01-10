package com.shiyulu.service;

import com.shiyulu.pojo.WaterBill;
import com.shiyulu.pojo.WaterOrder;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface WaterService {
    String order(WaterOrder waterOrder) throws NoSuchAlgorithmException;

    void changeState(WaterOrder waterOrder);

    WaterOrder findOrderByIdAndNumber(Integer waterOrderId, String waterOrderNumber);

    List<WaterOrder> listWaterOrder(Integer waterStationId, Integer state);

    void cancel(WaterOrder waterOrder);

    List<WaterBill> monthlyBillGenerator();

    void insertBills(List<WaterBill> waterBillList);
}
