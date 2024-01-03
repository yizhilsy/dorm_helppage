package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyPage {
    private Integer id;
    private String username;
    private String name;
    private String content;
    private LocalDateTime reply_time;
}
