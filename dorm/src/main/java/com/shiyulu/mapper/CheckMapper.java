package com.shiyulu.mapper;

import com.shiyulu.pojo.CheckRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CheckMapper {
    @Select("select * from student_records where student_number = #{id}")
    CheckRecord getById(Integer id);

//    @Update("update student_records set daily_penalty_reason=#{dailyPenaltyReason} where student_number = #{studentNumber}")
    void update(CheckRecord chr);

    public List<CheckRecord> list1(String studentNumber, String dormitoryNumber, Integer dailyScore, Integer monthlyScore);

    @Select("select * from student_records")
    List<CheckRecord> list();

    void update1(CheckRecord chr);

    void resetDailyScoreAndStatus();

    @Select("SELECT * FROM student_records ORDER BY monthly_score DESC LIMIT 8")
    List<CheckRecord> listtop();

    @Select("SELECT * FROM student_records ORDER BY monthly_score ASC LIMIT 8")
    List<CheckRecord> listbottom();

    void initializeData();
}
