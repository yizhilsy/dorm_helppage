package com.shiyulu.controller;//package com.shiyulu.controller;

import com.shiyulu.anno.RequireRole;
import com.shiyulu.pojo.ResultWang;
import com.shiyulu.pojo.User;
import com.shiyulu.service.ManagerService;
import com.shiyulu.service.UserService;
import com.shiyulu.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.shiyulu.utils.Constants.*;

@RestController
@RequestMapping("/manager")
@Validated
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    @RequireRole({MANAGER})
    @PostMapping("/addUser")
    public ResultWang addUser(@Pattern(regexp = "^\\S{5,16}$") String username, Integer role) {
        User u = userService.findByUserNmae(username);
        if (u == null) {
            //没有占用
            //判断role是否合法
            if (role < 0 || role > 3) {
                return ResultWang.error("该角色不存在");
            }
            //添加用户
            managerService.addUser(username, role);
            return ResultWang.success();
        } else {
            //占用
            return ResultWang.error("用户名已被占用");
        }
    }

    @RequireRole({MANAGER})
    @PostMapping("/resetPwd")
    public ResultWang resetUserPwd(@Pattern(regexp = "^\\S{5,16}$") String username){
        //检查该用户是否存在
        User u = userService.findByUserNmae(username);
        if(u == null){
            return ResultWang.error("该用户不存在");
        }
        //检查该用户名是不是自己
        Map<String, Object> map = ThreadLocalUtil.get();
        String ownUsername = (String) map.get("username");
        if(u.getUsername().equals(ownUsername)){
            return ResultWang.error("请前往重置密码页面进行本用户密码的修改");
        }
        managerService.resetUserPwd(username);
        return ResultWang.success();
    }

}
