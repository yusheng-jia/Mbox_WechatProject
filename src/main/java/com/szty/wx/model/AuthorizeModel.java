package com.szty.wx.model;

import java.util.List;

/**
 * Created by Jia on 2017/3/21.
 */
public class AuthorizeModel {
    public List<RespAuthorize> getResp() {
        return resp;
    }

    public void setResp(List<RespAuthorize> resp) {
        this.resp = resp;
    }

    private List<RespAuthorize> resp;

}
