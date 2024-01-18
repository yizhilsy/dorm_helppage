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

    @Select("select dormNumber, waterStationId, sum(waterCount) as waterCount, sum(waterCount) * (select waterPrice from waterStation where waterStation.waterStationId = waterOrder.waterStationId) as totalPrice from waterOrder where waterOrderStatus='未缴费' and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) group by dormNumber, waterStationId")
    List<WaterBill> monthlyBillGenerator();

    void insertBills(List<WaterBill> waterBillList);

//    @Select("select * from waterOrder where dormNumber=#{dormNumber}")
    List<WaterOrder> listWaterOrderByDorm(String dormNumber, Integer status);

    List<WaterBill> listWaterBill(String dormNumber, Integer status);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countTotalOrdered(String dormNumber);

    @Select("select sum(waterCount) from waterOrder where dormNumber=#{dormNumber} and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countTotalWaterCount(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='未接收' and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countUnconfirmed(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='运送中' and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countDelivering(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and waterOrderStatus='已取消' and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countCanceled(String dormNumber);

    @Select("select count(*) from waterOrder where dormNumber=#{dormNumber} and (waterOrderStatus='未缴费' or waterOrderStatus='已支付') and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7)")
    Integer countFinished(String dormNumber);

    @Select("select sum(waterCount * (select waterPrice from waterStation where waterStation.waterStationId = waterOrder.waterStationId )) from waterOrder where dormNumber=#{dormNumber} and substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterOrderStatus='未缴费'")
    String getCurrentPrice(String dormNumber);

    @Select("select * from waterStation where waterStationUsername = #{waterStationUsername}")
    WaterStation findWaterStationByUsername(String waterStationUsername);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and (waterOrderStatus='未缴费' or waterOrderStatus='已支付')")
    Integer countFinishedByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='运送中'")
    Integer countDeliveringByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='未接收'")
    Integer countUnconfirmedByWaterStationId(Integer waterStationId);

    @Select("select sum(waterCount) from waterOrder where substr(waterOrderTime, 1, 7) = substr(now(), 1, 7) and waterStationId=#{waterStationId} and waterOrderStatus='已取消'")
    Integer countCanceledByWaterStationId(Integer waterStationId);

    @Select("select * from waterStation")
    List<WaterStation> listWaterStation();

    @Select("select * from waterBill where waterBillId=#{waterBillId} and waterBillNumber=#{waterBillNumber} and dormNumber=#{dormNumber} and waterStationId=#{waterStationId} and totalPrice=#{totalPrice} and waterCount=#{waterCount}")
    WaterBill findBill(WaterBill waterBill);

    @Update("update waterBill set waterBillStatus='已支付' where waterBillId=#{waterBillId}")
    void pay(WaterBill waterBill);

    @Update("update waterOrder set waterOrderStatus='已支付' where dormNumber = #{dormNumber} and waterStationId = #{waterStationId}")
    void updateOrderStatus(WaterBill waterBill);
}
