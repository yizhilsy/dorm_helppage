package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Check {

    private Integer id;
    private String studentUserName;
    private String studentNumber;
    private LocalDateTime checkTime;
    private String checkReason;
    private String checkImg;
    private Integer checkValue;
    private String checker;
    private String appealReason;
    private String appealImg;
    private String status;

}
