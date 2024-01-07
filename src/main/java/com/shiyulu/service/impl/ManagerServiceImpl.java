package com.shiyulu.service.impl;//package com.wang.service.impl;

import com.shiyulu.mapper.ManagerMapper;
import com.shiyulu.service.ManagerService;
import com.shiyulu.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public void addUser(String username, Integer role) {
        //设置默认密码123456
        String pwd = "123456";
        pwd = Md5Util.getMD5String(pwd);
        //添加
        managerMapper.add(username,pwd,role);
    }

    @Override
    public void resetUserPwd(String username) {
        //设置默认密码123456
        String pwd = "123456";
        pwd = Md5Util.getMD5String(pwd);
        //重置密码
        managerMapper.resetPwd(username,pwd);
    }
}
