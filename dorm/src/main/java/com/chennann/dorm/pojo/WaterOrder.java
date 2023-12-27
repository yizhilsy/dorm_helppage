package com.chennann.dorm.pojo;

import com.chennann.dorm.anno.OrderState;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WaterOrder {
    @NotNull(groups = {Update.class, Cancel.class})
    private Integer waterOrderId;
    @NotEmpty(groups = {Update.class, Cancel.class})
    private String waterOrderNumber;
    @NotEmpty(groups = Add.class)
    private String dormNumber;
    @NotNull(groups = Add.class)
    private Integer studentId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime waterOrderTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime waterDeliverTime;
    @OrderState(groups = Update.class)
    private String waterOrderStatus;
    @NotNull(groups = Add.class)
    private Integer waterStationId;
    @NotNull(groups = Add.class)
    @Min(1)
    private Integer waterCount;


    public interface Add extends Default {

    }

    public interface Update extends Default{

    }

    public interface Cancel extends Default{

    }
}
