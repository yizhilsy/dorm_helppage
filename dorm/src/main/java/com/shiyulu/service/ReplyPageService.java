package com.shiyulu.service;

import com.shiyulu.pojo.ReplyPage;

import java.util.List;

public interface ReplyPageService {

    public List<ReplyPage> listByMainPageId(Integer id);

    void save(Integer id, ReplyPage replyPage);
}
