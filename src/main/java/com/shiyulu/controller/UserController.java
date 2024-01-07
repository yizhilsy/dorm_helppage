package com.shiyulu.controller;

import com.shiyulu.pojo.ResultWang;
import com.shiyulu.pojo.User;
import com.shiyulu.service.ManagerService;
import com.shiyulu.service.UserService;
import com.shiyulu.utils.JwtUtil;
import com.shiyulu.utils.Md5Util;
import com.shiyulu.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //注册
    @PostMapping("/register")
    public ResultWang register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

        //查询用户
        User u = userService.findByUserNmae(username);
        if (u == null) {
            //没有占用
            //注册用户
            userService.register(username, password);
            return ResultWang.success();
        } else {
            //占用
            return ResultWang.error("用户名已被占用");
        }

    }

    //登录
    @PostMapping("/login")
    public ResultWang login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //根据用户名查询用户
        User loginUser = userService.findByUserNmae(username);

        //判断该用户是否存在
        if (loginUser == null) {
            return ResultWang.error("用户名错误");
        }

        //判断密码是否正确 表中password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            claims.put("role", loginUser.getRole());
            //颁发令牌
            String token = JwtUtil.genToken(claims);
            //把token存储到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 1, TimeUnit.HOURS);

            return ResultWang.success(token);
        }

        return ResultWang.error("密码错误");
    }

    //退出登录
    @PostMapping("/logout")
    public ResultWang logout(@RequestHeader("Authorization") String token) {
        //清除redis中的令牌数据
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        //清空threadLocalUtil中的用户信息
        ThreadLocalUtil.remove();
        return ResultWang.success();
    }

    //查询用户信息
    @GetMapping("/userInfo")
    public ResultWang<User> userInfo() {
        //根据用户名查询用户
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        User user = userService.findByUserNmae(username);
        return ResultWang.success(user);
    }

    //更新用户基本信息
    @PutMapping("/update")
    public ResultWang update(@RequestBody @Validated User user) {
        userService.update(user);
        return ResultWang.success();
    }

    //更新用户头像
    @PatchMapping("/updateAvatar")
    public ResultWang updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return ResultWang.success();
    }

    //更新用户密码
    @PatchMapping("/updatePwd")
    public ResultWang updatePwd(@RequestParam Map<String, String> params, @RequestHeader("Authorization") String token) {
        //1.校验参数
        String oldPwd = params.get("oldPwd");
        String newPwd = params.get("newPwd");
        String rePwd = params.get("rePwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd))
            return ResultWang.error("缺少必要的参数");

        //检查原密码是否正确
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserNmae(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd)))
            return ResultWang.error("原密码填写不正确");

        //校验newPwd和rePwd是否一样
        if (!rePwd.equals(newPwd)) {
            return ResultWang.error("两次填写的密码不一致");
        }

        //2.调用service完成密码更新
        userService.updatePwd(newPwd);
        //删除redis中对应的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return ResultWang.success();
    }

}
