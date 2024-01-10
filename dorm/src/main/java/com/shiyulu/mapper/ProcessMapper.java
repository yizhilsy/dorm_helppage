package com.shiyulu.mapper;

import com.shiyulu.pojo.CheckRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProcessMapper {
    void process(CheckRecord chr);

    @Select("select * from student_records WHERE status = '已申诉'")
    public List<CheckRecord> list1(String dailyPenaltyImageUrl, String studentAppealReason);

    @Select("SELECT * FROM student_records WHERE student_number = #{id}")
    CheckRecord getById(Integer id);

    @Select("select * from student_records WHERE status = '已申诉'")
    List<CheckRecord> list();

    void process2(CheckRecord chr);

    @Select("SELECT daily_penaity_image_url FROM student_records WHERE student_number = #{id}")
    String getimg(Integer id);
}
