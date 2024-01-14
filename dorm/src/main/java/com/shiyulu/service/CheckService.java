package com.shiyulu.service;

import com.shiyulu.pojo.*;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckService {
    void add(CheckReceived checkReceived);

    Check findCheckByTimeAndNumber(LocalDateTime checkTime, String studentNumber);

    PageBeanChen<DailyScoreBoardItem> dailyScoreBoard(Integer pageNum, Integer pageSize, LocalDateTime date);

    PageBeanChen<Check> checkList(Integer pageNum, Integer pageSize, String studentNumber);

    void appeal(Appeal appeal);

    Check findCheckById(Integer checkId);

    PageBeanChen<Check> appeakList(Integer pageNum, Integer pageSize, String checkerUserName);

    void appealVerifyYes(Check check);

    void appealVerifyNo(Check check);

    PageBeanChen<Check> appeakStatus(Integer pageNum, Integer pageSize, String studentNumber);

    List<DailyScoreBoardItem> rankTop();

    List<DailyScoreBoardItem> rankBottom();


//    CheckRecord getById(Integer id);
//
//    void update(CheckRecord chr);
//
//    PageBean page(Integer page, Integer pageSize, String studentNumber, String dormitoryNumber, Integer dailyScore);
//
//    List<CheckRecord> list();
//
//    void update1(CheckRecord chr);
//
//    void resetDailyScoreAndStatus();
//
//    List<CheckRecord> listtop();
//
//    List<CheckRecord> listbottom();
//
//    void initializeData();


}
