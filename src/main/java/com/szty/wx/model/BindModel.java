package com.szty.wx.model;

/**
 * 绑定和解绑参数
 * Created by Jia on 2017/3/17.
 */
public class BindModel {
    private String ticket;
    private String device_id;
    private String openid;
    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public String getDevice_id() {
        return device_id;
    }
    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
