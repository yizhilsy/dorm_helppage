package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyWaterData {

    private String dormNumber;
    private Integer totalOrdered;
    private Integer totalWaterCount;
    private Integer unconfirmed;
    private Integer delivering;
    private Integer finished;
    private Integer canceled;
    private double currentPrice;

}
