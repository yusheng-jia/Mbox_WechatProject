package com.szty.wx.service.impl;

import com.szty.wx.dao.UserDao;
import com.szty.wx.service.UserService;
import com.szty.wx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Jia on 2017/2/27.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);

    }
}
