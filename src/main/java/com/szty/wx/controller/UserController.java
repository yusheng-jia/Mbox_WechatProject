package com.szty.wx.controller;

import com.szty.wx.model.User;
import com.szty.wx.service.WeiXinMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.szty.wx.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Jia on 2017/2/27.
 */
@Controller
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private WeiXinMenuService weiXinMenuService;
    @RequestMapping("/")
    public ModelAndView getIndex(){

        ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(2);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/createMenu")
    public ModelAndView createMenu(){

        weiXinMenuService.createMenu();
        ModelAndView mav = new ModelAndView("index");
        User user = userService.selectUserById(1);
        mav.addObject("user", user);
        return mav;
    }

}
