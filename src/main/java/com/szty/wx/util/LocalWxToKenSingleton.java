package com.szty.wx.util;

import com.alibaba.fastjson.JSON;
import com.szty.wx.model.AccToKenModel;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jia on 2017/3/3.
 */
public class LocalWxToKenSingleton {

    private static final Logger log = Logger
            .getLogger(LocalWxToKenSingleton.class);
    private static LocalWxToKenSingleton localWXtiken = null;

    /**
     * 缓冲时间
     */
    private static final Long cacheTime = 200L;
    /**
     * 微信token
     */
    private String access_token;
    /**
     * 过期时间
     */
    private String expires_in;

    /**
     * 查询时间
     */
    private Date createTime;

    private LocalWxToKenSingleton(String access_token, String expires_in,
                                  Date createTime) {
        super();
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.createTime = createTime;
    }

    /**
     *
     * @Description: TODO(获取ToKen)
     */
    public static LocalWxToKenSingleton getInstanceToKen(String toKenUrl,
                                                         String appId, String grantType, String appSecret) {
        if (localWXtiken != null
                && isTimeExpiresIn(localWXtiken.getCreateTime(),
                localWXtiken.getExpires_in())) {
            //心跳微信服务
            return localWXtiken;
        } else {
            synchronized (LocalWxToKenSingleton.class) {
                AccToKenModel accToKen = getWeiXinToken(toKenUrl, appId,grantType, appSecret);
                localWXtiken = new LocalWxToKenSingleton(
                        accToKen.getAccess_token(), accToKen.getExpires_in(),
                        new Date());
            }
            return localWXtiken;
        }

    }

    public synchronized static AccToKenModel getWeiXinToken(String toKenUrl,
                                                            String appId, String grantType, String appSecret) {
        log.debug("获取token");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appid", appId);
        map.put("grant_type", grantType);
        map.put("secret", appSecret);
        String res = HttpUtil.doGet(toKenUrl, map);
        if (!res.isEmpty()) {
            AccToKenModel accToKen = JSON.parseObject(res, AccToKenModel.class);
            if (accToKen.getAccess_token() != null
                    && accToKen.getErrcode() == null) {
                return accToKen;
            }
        }
        return null;

    }

    /**
     *
     * @Description: TODO(验证时间是否过期)
     */
    public static Boolean isTimeExpiresIn(Date createTime, String expires_in) {
        return DateUtil.isTimeExpiresIn(createTime,Long.valueOf(expires_in),cacheTime);
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
