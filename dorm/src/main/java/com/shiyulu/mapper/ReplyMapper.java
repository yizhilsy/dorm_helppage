package com.shiyulu.mapper;

import com.shiyulu.pojo.CheckRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReplyMapper {
    void addReply(CheckRecord chr);

    @Select("SELECT * FROM student_records WHERE student_number = #{id}")
    CheckRecord getById(String id);
}
