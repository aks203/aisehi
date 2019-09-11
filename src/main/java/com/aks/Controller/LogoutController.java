package com.aks.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LogoutController {
    @RequestMapping("/logout")
    public @ResponseBody String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "Logged out.. Please login again.";
    }
}
