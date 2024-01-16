package com.shiyulu.service;

import com.shiyulu.pojo.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface WaterService {
    String order(WaterOrder waterOrder) throws NoSuchAlgorithmException;

    void changeState(WaterOrder waterOrder);

    WaterOrder findOrderByIdAndNumber(Integer waterOrderId, String waterOrderNumber);

    PageBeanChen<WaterOrder> listWaterOrder(Integer pageNum, Integer pageSize, Integer waterStationId, Integer state, Integer today);

    void cancel(WaterOrder waterOrder);

    List<WaterBill> monthlyBillGenerator();

    void insertBills(List<WaterBill> waterBillList);

    PageBeanChen<WaterOrder> listWaterOrderByDorm(Integer pageNum, Integer pageSize, String dormNumber, Integer status);

    PageBeanChen<WaterBill> listBill(Integer pageNum, Integer pageSize, String dormNumber, Integer status);

    MonthlyWaterData generateMonthlyDataByDormNumber(String dormNumber);

    WaterStation findWaterStationByUsername(String waterStationUsername);

    Integer countFinishedByWaterStationId(Integer waterStationId);

    Integer countDeliveringByWaterStationId(Integer waterStationId);

    Integer countUnconfirmedByWaterStationId(Integer waterStationId);

    Integer countCanceledByWaterStationId(Integer waterStationId);
}
