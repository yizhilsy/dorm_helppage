package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyScoreBoardItem {

    private String studentNumber;
    private String dormNumber;
    private Integer dailyScore;
    private Integer monthlyScore;
    private String status;
}
