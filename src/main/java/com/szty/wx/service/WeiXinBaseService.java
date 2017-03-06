package com.szty.wx.service;

/**
 * Created by Jia on 2017/3/2.
 */
public interface WeiXinBaseService {

    /**
     * 获取微信服务器的 access_token
     * @return String
     */
    public String getWeiXinToken();
}
