package com.shiyulu.service.impl;

import com.shiyulu.mapper.MPMapper;
import com.shiyulu.mapper.ReplyPageMapper;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.service.ReplyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReplyPageServiceImpl implements ReplyPageService {
    @Autowired
    private ReplyPageMapper replyPageMapper;
    @Autowired
    private MPMapper mpMapper;
    @Override
    public List<ReplyPage> listByMainPageId(Integer id) {
        return replyPageMapper.listByMainPageId(id);
    }

    @Override
    public void save(Integer id, ReplyPage replyPage) {
        replyPage.setReplyTime(LocalDateTime.now());
        replyPageMapper.insert(replyPage);
        //获取新插入数据的主键id
        Integer rid = replyPage.getId();
        //在mp中间表中建立关系
        mpMapper.insert(id,rid);

    }
}
