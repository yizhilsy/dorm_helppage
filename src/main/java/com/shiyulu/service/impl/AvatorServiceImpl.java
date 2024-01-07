package com.shiyulu.service.impl;

import com.shiyulu.mapper.AvatorMapper;
import com.shiyulu.pojo.Avator;
import com.shiyulu.service.AvatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatorServiceImpl implements AvatorService {
    @Autowired
    private AvatorMapper avatorMapper;

    @Override
    public Avator getAvatorById(String username) {
        Avator avator = avatorMapper.getAvatorById(username);
        System.out.println("*******************");
        System.out.println(avator);
        System.out.println("*******************");
        return avator;
    }
}
