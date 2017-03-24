package com.szty.wx.model;

import java.util.List;

/**
 * 查询设备二维码，依据机器device
 * Created by Jia on 2017/3/17.
 */
public class CreateQrcode {
    public String device_num;
    public List<String> device_id_list;

    public String getDevice_num() {
        return device_num;
    }

    public void setDevice_num(String device_num) {
        this.device_num = device_num;
    }

    public List<String> getDevice_id_list() {
        return device_id_list;
    }

    public void setDevice_id_list(List<String> device_id_list) {
        this.device_id_list = device_id_list;
    }
}
