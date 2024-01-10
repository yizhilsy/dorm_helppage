package com.shiyulu.config;

import com.shiyulu.interceptors.LoginInterceptor;
import com.shiyulu.interceptors.ManageInterceptor;
import com.shiyulu.interceptors.ManageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private ManageInterceptor manageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //登录和注册接口不拦截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/register","/user/login");

        //管理功能拦截器
        registry.addInterceptor(manageInterceptor).addPathPatterns("/manager/**");
    }
}

