package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// CheckRecord.java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckRecord {
    private int id;
    private String studentNumber;
    private String username;
    private String dormitoryNumber;
    private int dailyScore;
    private int monthlyScore;
    private boolean balcony;
    private boolean rubbish;
    private boolean desk;
    private boolean floor;
    private boolean quilt;
    private String dailyPenaltyImageUrl;
    private String studentAppealReason;
    private String status;
    private String checkerUsername;
}
