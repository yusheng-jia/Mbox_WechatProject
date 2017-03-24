package com.szty.wx.controller;

import com.szty.wx.model.User;
import com.szty.wx.service.WeiXinMenuService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.szty.wx.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by Jia on 2017/2/27.
 */
@Controller
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private WeiXinMenuService weiXinMenuService;

    @RequestMapping("/")
    public ModelAndView mBox(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping(value = "/getUser",method = {RequestMethod.GET})
    public ModelAndView getIndex(){

        ModelAndView mav = new ModelAndView("view/index");
        User user = userService.selectUserById(2);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/link_device")
    public ModelAndView getPairNetwork(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/web/link_device/device");
        return mav;
    }


    @RequestMapping(value = "/createMenu",method = {RequestMethod.GET})
    public void createMenu(){
        log.info("createMenu ........");
        weiXinMenuService.createMenu();
    }

}
