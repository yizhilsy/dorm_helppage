package com.shiyulu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appeal {

    private Integer checkId;
    private String appealReason;
    private String appealImg;

}
