package com.aks.config;

import com.aks.Service.TokenService;
import com.aks.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Interceptor class for validation of user before completing api request.
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    TokenService tokenService;

    @Autowired
    JwtUtil jwtUtil;

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return true if user_id is not null and token is available against that id.
     * else return false and condemn the api request.
     * @throws Exception
     */
    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {

        boolean doesIdExist = request.getHeader("user_id") != null;
        if (doesIdExist){
            int user_id=Integer.parseInt(request.getHeader("user_id"));
            try {
                String token=tokenService.getToken(user_id);
                boolean isExpired= jwtUtil.isTokenExpired(token);
                if (isExpired){
                    return false;
                }
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