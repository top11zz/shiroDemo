package com.jbit.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {

    @RequestMapping("/loginPage")
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView("login.html");
        return mv;
    }

    @RequestMapping("/index")
    public String index(){
        return "main";
    }

    @RequestMapping("/errorPage")
    public String error(){
        return "error";
    }
}
