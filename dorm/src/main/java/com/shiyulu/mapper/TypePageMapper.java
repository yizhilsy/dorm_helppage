package com.shiyulu.mapper;

import com.github.pagehelper.Page;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.TypePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypePageMapper {
    List<TypePage> list();
}
