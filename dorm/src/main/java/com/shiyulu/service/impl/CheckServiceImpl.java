package com.shiyulu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyulu.mapper.CheckMapper;
import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.pojo.PageBean;
import com.shiyulu.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckMapper checkMapper;

    @Override
    public CheckRecord getById(Integer id) {
        return checkMapper.getById(id);
    }

    @Override
    public List<CheckRecord> list() {
        return checkMapper.list();
    }

    @Override
    public void update(CheckRecord chr) {
        checkMapper.update(chr);
    }

    @Override
    public void update1(CheckRecord chr) {
        checkMapper.update1(chr);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String studentNumber, String dormitoryNumber, Integer dailyScore, Integer monthlyScore) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<CheckRecord> CheckList = checkMapper.list1(studentNumber, dormitoryNumber, dailyScore, monthlyScore);
        Page<CheckRecord> p = (Page<CheckRecord>) CheckList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void resetDailyScoreAndStatus() {
        // 调用 Mapper 层的方法重置数据
        checkMapper.resetDailyScoreAndStatus();
    }

    @Override
    public List<CheckRecord> listtop() {
        return checkMapper.listtop();
    }

    @Override
    public List<CheckRecord> listbottom() {
        return checkMapper.listbottom();
    }

    @Override
    public void initializeData() {
        // 调用 Mapper 层的方法重置数据
        checkMapper.initializeData();
    }

}
