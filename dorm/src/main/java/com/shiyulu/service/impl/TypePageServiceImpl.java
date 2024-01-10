package com.shiyulu.service.impl;

import com.github.pagehelper.Page;
import com.shiyulu.mapper.TypePageMapper;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.TypePage;
import com.shiyulu.service.TypePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePageServiceImpl implements TypePageService {
    @Autowired
    private TypePageMapper typePageMapper;
    @Override
    public List<TypePage> list() {
        return typePageMapper.list();
    }
}
