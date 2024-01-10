package com.shiyulu.service;

import com.shiyulu.pojo.CheckRecord;

public interface ReplyService {
    void addReply(CheckRecord chr);

    CheckRecord getById(String id);
}
