package com.shiyulu.mapper;

import com.shiyulu.pojo.Appeal;
import com.shiyulu.pojo.Check;
import com.shiyulu.pojo.DailyScoreBoardItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CheckMapper {
    void add(List<Check> checkList);

    @Select("select * from studentCheck where substr(checkTime, 1, 10) = substr(#{checkTime}, 1, 10) and studentNumber = #{studentNumber} limit 1")
    Check findCheckByTimeAndNumber(LocalDateTime checkTime, String studentNumber);

    List<DailyScoreBoardItem> dailyScoreBoard(LocalDateTime date);

    @Select("select * from studentCheck where studentNumber = #{studentNumber}")
    List<Check> checkList(String studentNumber);

    @Update("update studentCheck set appealReason=#{appealReason}, appealImg=#{appealImg}, status='申诉中' where id = #{checkId}")
    void appeal(Appeal appeal);

    @Select("select * from studentCheck where id = #{checkId}")
    Check findCheckById(Integer checkId);

    @Select("select * from studentCheck where checker = #{checkerUserName} and status = '申诉中'")
    List<Check> appealList(String checkerUserName);

    @Update("update studentCheck set checkValue = #{checkValue}, status='申诉成功' where id = #{id}")
    void appealVerifyYes(Check check);

    @Update("update studentCheck set status='申诉失败' where id = #{id}")
    void appealVerifyNo(Check check);

    @Select("select * from studentCheck where studentNumber = #{studentNumber} and status != '已扣分'")
    List<Check> appealStatus(String studentNumber);

    List<DailyScoreBoardItem> rankTop();

    List<DailyScoreBoardItem> rankBottom();
//    @Select("select * from student_records where studentNumber = #{id}")
//    CheckRecord getById(Integer id);
//
////    @Update("update student_records set daily_penalty_reason=#{dailyPenaltyReason} where student_number = #{studentNumber}")
//    void update(List<RecordHistory> recordHistoryList);
//
//    List<CheckRecord> list1(String studentNumber, String dormitoryNumber, Integer dailyScore);
//
//    @Select("select * from student_records")
//    List<CheckRecord> list();
//
//    void update1(CheckRecord chr);
//
//    void resetDailyScoreAndStatus();
//
//    @Select("SELECT * FROM student_records ORDER BY monthlyScore DESC LIMIT 8")
//    List<CheckRecord> listtop();
//
//    @Select("SELECT * FROM student_records ORDER BY monthlyScore ASC LIMIT 8")
//    List<CheckRecord> listbottom();
//
//    void initializeData();


}
