package com.szty.wx.service;

import com.szty.wx.baseTest.SpringTestCase;
import com.szty.wx.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jia on 2017/2/28.
 */
public class UserServiceTest extends SpringTestCase {

    @Autowired
    private UserService userService;

    @Autowired
    private WeiXinMenuService weiXinMenuService;
    @Test
    public void selectUserByIdTest(){
        User user = userService.selectUserById(1);
        weiXinMenuService.createMenu();
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }
}
