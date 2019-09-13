package com.aks.config;

import com.aks.Service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    TokenService tokenService;
    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {
//        long startTime = System.currentTimeMillis();
//        RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(
//                RequestMapping.class);

        boolean doesIdExist = request.getHeader("user_id") != null;
        if (doesIdExist){
            int user_id=Integer.parseInt(request.getHeader("user_id"));
            try {
                String token=tokenService.getToken(user_id);
                if(token==null){
                    response.setHeader("msg", "session invalid");
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                }
                return true;
            }
            catch (EntityNotFoundException notFoundExc){

            }
        }

        return false;
    }
}