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

    Integer getLikeNumById(Integer id);

    List<Integer> getLikeUsersById(Integer id);

    void addLike(Integer id);

    void addLikeUser(Integer id, Integer u_id);

    void cancelLike(Integer id);

    void cancelLikeUser(Integer id, Integer u_id);

    void initLikeNum(Integer id,Integer initNum);

    void dropLikeNum(List<Integer> ids);

    void dropLikeUser(List<Integer> ids);

    List<HelpPage> hotest5();
}
