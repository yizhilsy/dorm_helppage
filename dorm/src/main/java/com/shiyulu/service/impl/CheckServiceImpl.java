package com.shiyulu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyulu.mapper.CheckMapper;
import com.shiyulu.pojo.*;
import com.shiyulu.service.CheckService;
import com.shiyulu.service.StudentService;
import com.shiyulu.utils.ThreadLocalUtil;
import org.apache.catalina.filters.RemoteHostFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public void add(CheckReceived checkReceived) {

        List<Check> checkList = new ArrayList<>();

        //获取studentUserName
        String studentUserName = studentService.getStudentUserNameByNumber(checkReceived.getStudentNumber());

        //获取checker
        Map<String, Object> map= ThreadLocalUtil.get();
        String checker = (String) map.get("username");
        if (checkReceived.getBalcony() > 0) {
            checkList.add(new Check(null, studentUserName, checkReceived.getStudentNumber(), checkReceived.getCheckTime(), "阳台", "".equals(checkReceived.getDailyPenaltyImageUrlForBalcony()) ? null : checkReceived.getDailyPenaltyImageUrlForBalcony(), checkReceived.getBalcony(), checker, null, null, "已扣分"));
        }
        if (checkReceived.getRubbish() > 0) {
            checkList.add(new Check(null, studentUserName, checkReceived.getStudentNumber(), checkReceived.getCheckTime(), "垃圾", "".equals(checkReceived.getDailyPenaltyImageUrlForRubbish()) ? null : checkReceived.getDailyPenaltyImageUrlForRubbish(), checkReceived.getRubbish(), checker, null, null, "已扣分"));
        }
        if (checkReceived.getDesk() > 0) {
            checkList.add(new Check(null, studentUserName, checkReceived.getStudentNumber(), checkReceived.getCheckTime(), "桌面", "".equals(checkReceived.getDailyPenaltyImageUrlForDesk()) ? null : checkReceived.getDailyPenaltyImageUrlForDesk(), checkReceived.getDesk(), checker, null, null, "已扣分"));
        }
        if (checkReceived.getFloor() > 0) {
            checkList.add(new Check(null, studentUserName, checkReceived.getStudentNumber(), checkReceived.getCheckTime(), "地面", "".equals(checkReceived.getDailyPenaltyImageUrlForFloor()) ? null : checkReceived.getDailyPenaltyImageUrlForFloor(), checkReceived.getFloor(), checker, null, null, "已扣分"));
        }
        if (checkReceived.getQuilt() > 0) {
            checkList.add(new Check(null, studentUserName, checkReceived.getStudentNumber(), checkReceived.getCheckTime(), "被子", "".equals(checkReceived.getDailyPenaltyImageUrlForQuilt()) ? null : checkReceived.getDailyPenaltyImageUrlForQuilt(), checkReceived.getQuilt(), checker, null, null, "已扣分"));
        }

        checkMapper.add(checkList);
    }

    @Override
    public Check findCheckByTimeAndNumber(LocalDateTime checkTime, String studentNumber) {

        return checkMapper.findCheckByTimeAndNumber(checkTime, studentNumber);
    }

    @Override
    public PageBeanChen<DailyScoreBoardItem> dailyScoreBoard(Integer pageNum, Integer pageSize, LocalDateTime date) {

        PageBeanChen<DailyScoreBoardItem> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);


        List<DailyScoreBoardItem> as = checkMapper.dailyScoreBoard(date);
        Page<DailyScoreBoardItem> p = (Page<DailyScoreBoardItem>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBeanChen<Check> checkList(Integer pageNum, Integer pageSize, String studentNumber) {

        PageBeanChen<Check> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);


        List<Check> as = checkMapper.checkList(studentNumber);
        Page<Check> p = (Page<Check>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void appeal(Appeal appeal) {

        if ("".equals(appeal.getAppealImg())) {
            appeal.setAppealImg(null);
        }
        checkMapper.appeal(appeal);
    }

    @Override
    public Check findCheckById(Integer checkId) {

        return checkMapper.findCheckById(checkId);
    }

    @Override
    public PageBeanChen<Check> appeakList(Integer pageNum, Integer pageSize, String checkerUserName) {

        PageBeanChen<Check> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);


        List<Check> as = checkMapper.appealList(checkerUserName);
        Page<Check> p = (Page<Check>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void appealVerifyYes(Check check) {

        checkMapper.appealVerifyYes(check);
    }

    @Override
    public void appealVerifyNo(Check check) {

        checkMapper.appealVerifyNo(check);
    }

    @Override
    public PageBeanChen<Check> appeakStatus(Integer pageNum, Integer pageSize, String studentNumber) {

        PageBeanChen<Check> pb = new PageBeanChen<>();
        PageHelper.startPage(pageNum, pageSize);


        List<Check> as = checkMapper.appealStatus(studentNumber);
        Page<Check> p = (Page<Check>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public List<DailyScoreBoardItem> rankTop() {

        return checkMapper.rankTop();
    }

    @Override
    public List<DailyScoreBoardItem> rankBottom() {

        return checkMapper.rankBottom();
    }

//    @Override
//    public CheckRecord getById(Integer id) {
//        return checkMapper.getById(id);
//    }
//
//    @Override
//    public List<CheckRecord> list() {
//        return checkMapper.list();
//    }
//
//    @Override
//    public void update(CheckRecord chr) {
//
//        List<RecordHistory> recordHistoryList = new ArrayList<>();
//        String stuNum = chr.getStudentNumber();
//        Map<String, Object> map= ThreadLocalUtil.get();
//        String checker = (String) map.get("username");
//        if (chr.isBalcony()) {
//            recordHistoryList.add(new RecordHistory(stuNum, LocalDateTime.now(), 1, null, null, "", checker));
//        }
//        if (chr.isRubbish()) {
//            recordHistoryList.add(new RecordHistory(stuNum, LocalDateTime.now(), 2, null, null, "", checker));
//        }
//        if (chr.isDesk()) {
//            recordHistoryList.add(new RecordHistory(stuNum, LocalDateTime.now(), 3, null, null, "", checker));
//        }
//        if (chr.isFloor()) {
//            recordHistoryList.add(new RecordHistory(stuNum, LocalDateTime.now(), 4, null, null, "", checker));
//        }
//
//        if (chr.isQuilt()) {
//            recordHistoryList.add(new RecordHistory(stuNum, LocalDateTime.now(), 5, null, null, "", checker));
//        }
//
//        checkMapper.update(recordHistoryList);
//    }
//
//    @Override
//    public void update1(CheckRecord chr) {
//        checkMapper.update1(chr);
//    }
//
//    @Override
//    public PageBean page(Integer page, Integer pageSize, String studentNumber, String dormitoryNumber, Integer dailyScore) {
//        //1. 设置分页参数
//        PageHelper.startPage(page,pageSize);
//
//        //2. 执行查询
//        List<CheckRecord> CheckList = checkMapper.list1(studentNumber, dormitoryNumber, dailyScore);
//        Page<CheckRecord> p = (Page<CheckRecord>) CheckList;
//
//        //3. 封装PageBean对象
//        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
//        return pageBean;
//    }
//
//    @Override
//    public void resetDailyScoreAndStatus() {
//        // 调用 Mapper 层的方法重置数据
//        checkMapper.resetDailyScoreAndStatus();
//    }
//
//    @Override
//    public List<CheckRecord> listtop() {
//        return checkMapper.listtop();
//    }
//
//    @Override
//    public List<CheckRecord> listbottom() {
//        return checkMapper.listbottom();
//    }
//
//    @Override
//    public void initializeData() {
//        // 调用 Mapper 层的方法重置数据
//        checkMapper.initializeData();
//    }



}
