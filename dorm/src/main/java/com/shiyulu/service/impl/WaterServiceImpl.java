package com.shiyulu.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyulu.mapper.WaterMapper;
import com.shiyulu.pojo.*;
import com.shiyulu.service.WaterService;
import com.shiyulu.utils.NumberUtil;
import com.shiyulu.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    private WaterMapper waterMapper;


    @Override
    public String order(WaterOrder waterOrder) throws NoSuchAlgorithmException {

        String orderNumber = NumberUtil.generateShortOrderNumber();
        waterOrder.setWaterOrderNumber(orderNumber);
        waterOrder.setWaterOrderStatus("未接收");
        waterMapper.order(waterOrder);
        return orderNumber;
    }

    @Override
    public void changeState(WaterOrder waterOrder) {
        waterMapper.changeState(waterOrder);
    }

    @Override
    public WaterOrder findOrderByIdAndNumber(Integer waterOrderId, String waterOrderNumber) {
        return waterMapper.findOrderByIdAndNumber(waterOrderId, waterOrderNumber);
    }

    @Override
    public PageBeanChen<WaterOrder> listWaterOrder(Integer pageNum, Integer pageSize, Integer waterStationId, Integer state, Integer today) {
        PageBeanChen<WaterOrder> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);


        List<WaterOrder> wl = waterMapper.listWaterOrder(waterStationId, state, today);
        Page<WaterOrder> p = (Page<WaterOrder>) wl;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void cancel(WaterOrder waterOrder) {

        waterMapper.cancel(waterOrder);
    }

    @Override
    public List<WaterBill> monthlyBillGenerator() {

        return waterMapper.monthlyBillGenerator();
    }

    @Override
    public void insertBills(List<WaterBill> waterBillList) {
        waterMapper.insertBills(waterBillList);
    }

    @Override
    public PageBeanChen<WaterOrder> listWaterOrderByDorm(Integer pageNum, Integer pageSize, String dormNumber, Integer status) {

        PageBeanChen<WaterOrder> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);

        List<WaterOrder> wl = waterMapper.listWaterOrderByDorm(dormNumber, status);
        Page<WaterOrder> p = (Page<WaterOrder>) wl;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBeanChen<WaterBill> listBill(Integer pageNum, Integer pageSize, String dormNumber, Integer status) {

        PageBeanChen<WaterBill> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);

        List<WaterBill> wl = waterMapper.listWaterBill(dormNumber, status);
        Page<WaterBill> p = (Page<WaterBill>) wl;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public MonthlyWaterData generateMonthlyDataByDormNumber(String dormNumber) {

        MonthlyWaterData monthlyWaterData = new MonthlyWaterData();
        monthlyWaterData.setDormNumber(dormNumber);
        monthlyWaterData.setTotalOrdered(waterMapper.countTotalOrdered(dormNumber));
        monthlyWaterData.setTotalWaterCount(waterMapper.countTotalWaterCount(dormNumber));
        monthlyWaterData.setUnconfirmed(waterMapper.countUnconfirmed(dormNumber));
        monthlyWaterData.setDelivering(waterMapper.countDelivering(dormNumber));
        monthlyWaterData.setCanceled(waterMapper.countCanceled(dormNumber));
        monthlyWaterData.setFinished(waterMapper.countFinished(dormNumber));
        String curPrice = waterMapper.getCurrentPrice(dormNumber);
        Double CurrentPrice;
        CurrentPrice = Double.valueOf(curPrice==null ? "0" : curPrice);
        monthlyWaterData.setCurrentPrice(CurrentPrice);

        return monthlyWaterData;
    }

    @Override
    public WaterStation findWaterStationByUsername(String waterStationUsername) {

        return waterMapper.findWaterStationByUsername(waterStationUsername);
    }
}
