package com.jbit.demo.controller;
import	java.util.HashMap;


import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BaseController extends ExceptionHandlers {
    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public Map<String,Object> authorizationException(Exception e){
        System.out.println("errorInfo------------------------------无权限");
        Map<String, Object> map = new HashMap<String, Object> ();
        map.put("success",false);
        map.put("errorInfo","无权限");
        map.put("msg", e.getMessage());
        return map;
    }
}
