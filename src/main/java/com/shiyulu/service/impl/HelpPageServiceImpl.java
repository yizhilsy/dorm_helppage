package com.shiyulu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyulu.mapper.HelpPageMapper;
import com.shiyulu.pojo.HelpPage;
import com.shiyulu.pojo.PageBean;
import com.shiyulu.service.HelpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HelpPageServiceImpl implements HelpPageService {
    @Autowired
    private HelpPageMapper helpPageMapper;

    @Override
    public List<HelpPage> list() {
        List<HelpPage> helpPageList = helpPageMapper.list();
        return helpPageList;
    }

    @Override
    public void save(HelpPage helpPage) {
        helpPage.setCreateTime(LocalDateTime.now());
        helpPage.setUpdateTime(LocalDateTime.now());
        helpPageMapper.insert(helpPage);
    }

    @Override
    public void delete(List<Integer> ids) {
        helpPageMapper.delete(ids);
    }

    @Override
    public HelpPage getById(Integer id) {
        return helpPageMapper.getById(id);
    }

    @Override
    public void update(HelpPage helpPage) {
        helpPage.setUpdateTime(LocalDateTime.now());
        helpPageMapper.update(helpPage);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, Integer typeId, LocalDateTime begin, LocalDateTime end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);
        //2. 执行查询, 此时已经是分页查询结果的封装了
        List<HelpPage> helpPageList = helpPageMapper.page(typeId,begin,end);
        Page<HelpPage> p = (Page<HelpPage>) helpPageList;
        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
