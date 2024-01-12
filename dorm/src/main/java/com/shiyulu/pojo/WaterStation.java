package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterStation {
    private Integer waterStationId;
    private String waterStationUsername;
    private String waterStationName;
    private String waterStationLocation;
    private Integer waterPrice;
}
