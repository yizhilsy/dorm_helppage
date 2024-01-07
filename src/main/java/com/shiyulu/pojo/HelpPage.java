package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelpPage {
    private Integer id;
    private String username;
    private String name;
    private String phone;
    private String title;
    private String content;
    private String image;
    private Short typeId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
