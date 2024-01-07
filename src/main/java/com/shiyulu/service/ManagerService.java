package com.shiyulu.service;//package com.wang.service;

public interface ManagerService {
    //添加用户
    void addUser(String username,Integer role);

    //重置用户密码
    void resetUserPwd(String username);
}
