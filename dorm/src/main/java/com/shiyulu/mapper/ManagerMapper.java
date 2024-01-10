package com.shiyulu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ManagerMapper {
    //添加
    @Insert("insert into user(username,password,create_time,update_time,role)" +
            "values(#{username},#{password},now(),now(),#{role})")
    void add(String username, String password, Integer role);

    //更新用户密码
    @Update("update user set password = #{password}, update_time=now() where username = #{username}")
    void resetPwd(String username, String password);
}
