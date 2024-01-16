package com.shiyulu.mapper;

import com.shiyulu.pojo.WaterBill;
import com.shiyulu.pojo.WaterOrder;
import com.shiyulu.pojo.WaterOrder;
import com.shiyulu.pojo.WaterStation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WaterMapper {

    void order(WaterOrder waterOrder);

    @Update("update waterOrder set waterOrderStatus=#{waterOrderStatus} where waterOrderId=#{waterOrderId}")
    void changeState(WaterOrder waterOrder);

    @Select("select * from waterOrder where waterOrderId=#{waterOrderId} and waterOrderNumber=#{waterOrderNumber}")
    WaterOrder findOrderByIdAndNumber(Integer waterOrderId, String waterOrderNumber);

    List<WaterOrder> listWaterOrder(Integer waterStationId, Integer state, Integer today);

    @Update("update waterOrder set waterOrderStatus='已取消' where waterOrderId=#{waterOrderId} and waterOrderNumber=#{waterOrderNumber}")
    void cancel(WaterOrder waterOrder);

    @Select("select dormNumber, waterStationId, sum(waterCount) as waterCount, sum(waterCount) * (select waterPrice from waterStation where waterStation.waterStationId = waterOrder.waterStationId) as totalPrice from waterOrder where waterOrderStatus='已完成' group by dormNumber, waterStationId")
    List<WaterBill> monthlyBillGenerator();

    void insertBills(List<WaterBill> waterBillList);

//    @Select("select * from waterOrder where dormNumber=#{dormNumber}")
    List<WaterOrder> listWaterOrderByDorm(String dormNumber, Integer status);

    List<WaterBill> listWaterBill(String dormNumber, Integer status);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and month(waterOrderTime) = month(now())")
    Integer countTotalOrdered(String dormNumber);

    @Select("select sum(waterCount) from waterOrder where dormNumber=#{dormNumber} and month(waterOrderTime) = month(now())")
    Integer countTotalWaterCount(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='未接收' and month(waterOrderTime) = month(now())")
    Integer countUnconfirmed(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='运送中' and month(waterOrderTime) = month(now())")
    Integer countDelivering(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='已取消' and month(waterOrderTime) = month(now())")
    Integer countCanceled(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='已完成' and month(waterOrderTime) = month(now())")
    Integer countFinished(String dormNumber);

    @Select("select sum(waterCount * (select waterPrice from waterStation where waterStation.waterStationId = waterOrder.waterStationId )) from waterOrder where dormNumber=#{dormNumber} and month(waterOrderTime) = month(now()) and waterOrderStatus='已完成'")
    String getCurrentPrice(String dormNumber);

    @Select("select * from waterStation where waterStationUsername = #{waterStationUsername}")
    WaterStation findWaterStationByUsername(String waterStationUsername);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='已完成'")
    Integer countFinishedByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='运送中'")
    Integer countDeliveringByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='未接收'")
    Integer countUnconfirmedByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='已取消'")
    Integer countCanceledByWaterStationId(Integer waterStationId);
}
