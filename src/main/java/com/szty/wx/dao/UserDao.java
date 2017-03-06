package com.szty.wx.dao;

import com.szty.wx.model.User;


/**
 * Created by Jia on 2017/2/28.
 */

public interface UserDao {
    /** * @param userId * @return User */
    public User selectUserById(Integer userId);
}
