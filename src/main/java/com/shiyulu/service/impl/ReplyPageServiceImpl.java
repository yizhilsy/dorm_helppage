package com.shiyulu.service.impl;

import com.shiyulu.mapper.ReplyPageMapper;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.service.ReplyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyPageServiceImpl implements ReplyPageService {
    @Autowired
    private ReplyPageMapper replyPageMapper;

    @Override
    public List<ReplyPage> listByMainPageId(Integer id) {
        return replyPageMapper.listByMainPageId(id);
    }
}
