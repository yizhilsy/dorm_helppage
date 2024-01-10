package com.shiyulu.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MPMapper {
    //id：主页面主键，rid：回复帖主键
    void insert(Integer id, Integer rid);
}
