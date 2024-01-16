package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterStationMonthlyData {
    private Integer waterStationId;
    private Integer finished;
    private Integer delivering;
    private Integer unconfirmed;
    private Integer canceled;
}
