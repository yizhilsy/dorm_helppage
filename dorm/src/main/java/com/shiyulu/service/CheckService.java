package com.shiyulu.service;

import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.pojo.PageBean;

import java.util.List;

public interface CheckService {
    /**
     * 根据ID查询学生
     * @param id
     * @return
     */
    CheckRecord getById(Integer id);

    /**
     * 更新学生
     * @param chr
     */
    void update(CheckRecord chr);

    PageBean page(Integer page, Integer pageSize, String studentNumber, String dormitoryNumber, Integer dailyScore, Integer monthlyScore);

    List<CheckRecord> list();

    void update1(CheckRecord chr);

    void resetDailyScoreAndStatus();

    List<CheckRecord> listtop();

    List<CheckRecord> listbottom();

    void initializeData();
}
