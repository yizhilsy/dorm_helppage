package com.shiyulu.mapper;

import com.shiyulu.pojo.ReplyPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyPageMapper {
    List<ReplyPage> listByMainPageId(Integer id);
}
