package com.shiyulu.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shiyulu.mapper.HelpPageMapper;
import com.shiyulu.pojo.HelpPage;
import com.shiyulu.pojo.PageBean;
import com.shiyulu.service.HelpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        //初始化likeNumTable中的表项
        Integer initNum = 0;
        helpPageMapper.initLikeNum(helpPage.getId(),initNum);
    }

    @Override
    public void delete(List<Integer> ids) {
        helpPageMapper.delete(ids);
        //drop likeNumTable中的数据
        helpPageMapper.dropLikeNum(ids);
        //drop likeUserTable中的数据
        helpPageMapper.dropLikeUser(ids);
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
    public PageBean page(Integer page, Integer pageSize, Integer typeId, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);
        //2. 执行查询, 此时已经是分页查询结果的封装了
        List<HelpPage> helpPageList = helpPageMapper.page(typeId,begin,end);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(helpPageList);
        Page<HelpPage> p = (Page<HelpPage>) helpPageList;
        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public List<HelpPage> listByUsername(String username) {
        return helpPageMapper.listByUsername(username);
    }

    @Override
    public Integer getLikeNumById(Integer id) {
        Integer likeNum = helpPageMapper.getLikeNumById(id);
        System.out.println(likeNum);
        return likeNum;
    }

    @Override
    public List<Integer> getLikeUserById(Integer id) {
        List<Integer> likeUsers = helpPageMapper.getLikeUsersById(id);
        return likeUsers;
    }

    @Override
    public void addLike(Integer id, Integer u_id) {
        helpPageMapper.addLike(id);
        helpPageMapper.addLikeUser(id,u_id);
    }

    @Override
    public void cancelLike(Integer id, Integer u_id) {
        helpPageMapper.cancelLike(id);
        helpPageMapper.cancelLikeUser(id,u_id);
    }

    @Override
    public List<HelpPage> hotest5() {
        return helpPageMapper.hotest5();
    }

    @Override
    public PageBean myLikePages(Integer page, Integer pageSize, Integer typeId, LocalDate begin, LocalDate end, Integer uid) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);
        //2. 执行查询, 此时已经是分页查询结果的封装了
        List<HelpPage> helpPageList = helpPageMapper.myLikePages(typeId,begin,end,uid);
        Page<HelpPage> p = (Page<HelpPage>) helpPageList;
        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
}
