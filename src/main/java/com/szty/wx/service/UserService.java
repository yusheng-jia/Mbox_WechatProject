package com.szty.wx.service;

import com.szty.wx.model.User;


/**
 * Created by Jia on 2017/2/27.
 */
public interface UserService {
    User selectUserById(Integer userId);
}
