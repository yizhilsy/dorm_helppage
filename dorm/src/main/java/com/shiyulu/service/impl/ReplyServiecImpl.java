package com.shiyulu.service.impl;

import com.shiyulu.mapper.ReplyMapper;
import com.shiyulu.pojo.CheckRecord;
import com.shiyulu.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiecImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void addReply(CheckRecord chr) {
        replyMapper.addReply(chr);
    }

    @Override
    public CheckRecord getById(String id) {
        return replyMapper.getById(id);
    }



}
