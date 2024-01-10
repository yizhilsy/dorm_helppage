package com.shiyulu.controller;

import com.github.pagehelper.Page;
import com.shiyulu.pojo.ReplyPage;
import com.shiyulu.pojo.Result;
import com.shiyulu.pojo.TypePage;
import com.shiyulu.service.TypePageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/type")
public class TypePageController {
    @Autowired
    private TypePageService typePageService;
    @GetMapping
    public Result list(){
        List<TypePage> typePageList = typePageService.list();
        return Result.success(typePageList);
    }
}
