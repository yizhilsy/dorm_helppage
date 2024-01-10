package com.shiyulu.service;

import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.pojo.PageBean;

import java.util.List;

public interface ProcessService {
    void process(CheckRecord chr);

    CheckRecord getById(Integer id);

    PageBean page(Integer page, Integer pageSize, String dailyPenaltyImageUrl, String studentAppealReason);

    List<CheckRecord> list();

    void process2(CheckRecord chr);

    String getimg(CheckRecord chr);
}
