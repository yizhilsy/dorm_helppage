package com.shiyulu.interceptors;

import com.shiyulu.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class ManageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        //校验权限
        try {
            Map<String, Object> map = ThreadLocalUtil.get();
            Integer userrole = (Integer) map.get("role");
            if(userrole > 0){
                throw new RuntimeException();
            }
            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }

}
