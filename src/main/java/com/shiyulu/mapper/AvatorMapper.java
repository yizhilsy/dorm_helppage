package com.shiyulu.mapper;

import com.shiyulu.pojo.Avator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AvatorMapper {
    Avator getAvatorById(String username);
}
