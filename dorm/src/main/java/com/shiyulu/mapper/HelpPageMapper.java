package com.shiyulu.mapper;

import com.shiyulu.pojo.HelpPage;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface HelpPageMapper {

    //查询全部互助帖
    List<HelpPage> list();

    void insert(HelpPage helpPage);

    void delete(List<Integer> ids);

    HelpPage getById(Integer id);

    void update(HelpPage helpPage);

    List<HelpPage> page(Integer typeId, LocalDate begin, LocalDate end);

    List<HelpPage> listByUsername(String username);
}
