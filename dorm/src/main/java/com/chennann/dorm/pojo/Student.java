package com.chennann.dorm.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private Integer studentId;
    private String studentName;
    private String dormNumber;
    private String location;
    private Integer bedNumber;
    private String phone;
    private String email;
    private String studentNumber;
    private String password;

}
