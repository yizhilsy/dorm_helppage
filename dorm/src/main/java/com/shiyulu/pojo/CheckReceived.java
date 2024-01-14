package com.shiyulu.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckReceived {

    private String studentNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkTime;
    private Integer balcony;
    private Integer rubbish;
    private Integer desk;
    private Integer floor;
    private Integer quilt;
    private String dailyPenaltyImageUrlForBalcony;
    private String dailyPenaltyImageUrlForRubbish;
    private String dailyPenaltyImageUrlForDesk;
    private String dailyPenaltyImageUrlForFloor;
    private String dailyPenaltyImageUrlForQuilt;
}
