package com.szty.wx.model;

/**
 * Created by Jia on 2017/3/21.
 */
public class RespAuthorize extends ReqModel{
    private BaseInfo baseinfo;

    public BaseInfo getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(BaseInfo baseinfo) {
        this.baseinfo = baseinfo;
    }

    class BaseInfo {

        private String device_type;
        private String device_id;

        public String getDevice_type() {
            return device_type;
        }

        public void setDevice_type(String device_type) {
            this.device_type = device_type;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

    }
}
