package com.szty.wx.model;

/**
 * Created by Jia on 2017/3/3.
 */
public class ClickButton extends Button{
    private String key;// click等点击类型必须 菜单KEY值，用于消息接口推送，不超过128字节

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;

    }
}
