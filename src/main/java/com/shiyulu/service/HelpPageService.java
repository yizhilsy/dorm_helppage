package com.shiyulu.service;

import com.shiyulu.pojo.HelpPage;
import com.shiyulu.pojo.PageBean;

import java.time.LocalDateTime;
import java.util.List;

public interface HelpPageService {
    List<HelpPage> list();

    void save(HelpPage helpPage);

    void delete(List<Integer> ids);

    HelpPage getById(Integer id);

    void update(HelpPage helpPage);

    PageBean page(Integer page, Integer pageSize, Integer typeId,
                  LocalDateTime begin, LocalDateTime end);
}
