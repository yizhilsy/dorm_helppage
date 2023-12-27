package com.chennann.dorm.service.impl;


import com.chennann.dorm.mapper.WaterMapper;
import com.chennann.dorm.pojo.WaterOrder;
import com.chennann.dorm.service.WaterService;
import com.chennann.dorm.util.OrderNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    private WaterMapper waterMapper;


    @Override
    public String order(WaterOrder waterOrder) throws NoSuchAlgorithmException {

        String orderNumber = OrderNumberUtil.generateShortOrderNumber();
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
    public List<WaterOrder> listWaterOrder(Integer waterStationId, Integer state) {
        return waterMapper.listWaterOrder(waterStationId, state);
    }

    @Override
    public void cancel(WaterOrder waterOrder) {
        waterMapper.cancel(waterOrder);
    }
}
