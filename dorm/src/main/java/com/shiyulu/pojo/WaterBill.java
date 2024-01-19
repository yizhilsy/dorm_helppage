package com.shiyulu.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterBill {

    @NotEmpty
    private Integer waterBillId;
    @NotEmpty
    private String waterBillNumber;
    @NotEmpty
    private String dormNumber;
    private String waterBillStatus;
    @NotNull
    private Integer waterStationId;
    @NotEmpty
    private String waterStationName;
    @NotNull
    private Double totalPrice;
    @NotNull
    private Integer waterCount;

}
