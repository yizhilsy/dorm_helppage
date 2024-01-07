package com.shiyulu.pojo;


//统一响应结果

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultWang<T> {
    private Integer code;//业务状态码  1-成功  0-失败
    private String msg;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> ResultWang<E> success(E data) {

        return new ResultWang<>(1, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static ResultWang success() {
        return new ResultWang(1, "操作成功", null);
    }

    public static ResultWang error(String message) {
        return new ResultWang(0, message, null);
    }
}
