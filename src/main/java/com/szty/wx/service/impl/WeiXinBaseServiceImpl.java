package com.szty.wx.service.impl;

import com.szty.wx.service.WeiXinBaseService;
import com.szty.wx.util.LocalWxToKenSingleton;
import com.szty.wx.util.WeiXinConfing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jia on 2017/3/2.
 */
@Service
public class WeiXinBaseServiceImpl implements WeiXinBaseService {
    private Logger logger = Logger.getLogger(WeiXinBaseServiceImpl.class);

    @Autowired
    private WeiXinConfing weiXinConfing;

    public String getWeiXinToken() {
        logger.debug("获取微信ToKen==-================start=========================>>>");
        LocalWxToKenSingleton locToken = LocalWxToKenSingleton
                .getInstanceToKen(weiXinConfing.accessTokenCreateUrl,
                        weiXinConfing.appid, weiXinConfing.grantType, weiXinConfing.appsecret);
        logger.debug("获取微信ToKen===>>>ToKen["+locToken.getAccess_token()+"]");
        logger.debug("获取微信ToKen==-================start=========================>>>");
        return locToken.getAccess_token();
    }
}
