package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterBill {

    private Integer waterBillId;
    private String waterBillNumber;
    private String dormNumber;
    private String waterBillStatus;
    private Integer waterStationId;
    private Double totalPrice;
    private Integer waterCount;

}
