//package com.jbit.demo.config;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//public class MyExceptionResolver implements HandlerExceptionResolver {
//
//    public ModelAndView resolveException(HttpServletRequest request,
//                                         HttpServletResponse response, Object handler, Exception ex) {
//        // TODO Auto-generated method stub
//        System.out.println("==============异常开始=============");
//        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
//        if(ex instanceof UnauthorizedException){
//            System.out.println("inininininininininin");
//            ModelAndView mv = new ModelAndView("error.html");
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("success", false);
//            map.put("errorInfo", "没权限");
//            mv.addAllObjects(map);
//            return mv;
//        }
//        ex.printStackTrace();
//        System.out.println("==============异常结束=============");
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
//        return mv;
//    }
//}
