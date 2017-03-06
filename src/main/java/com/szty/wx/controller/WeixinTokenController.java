package com.szty.wx.controller;

import com.szty.wx.model.WeiXinResModel;
import com.szty.wx.util.WeiXinConfing;
import com.szty.wx.util.WeiXinUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by Jia on 2017/3/1.
 */
@Controller
@RequestMapping(value="/getToken")
public class WeixinTokenController {
    private static final Logger log = Logger.getLogger(WeixinTokenController.class);
    @Autowired
    public WeiXinConfing wexinConfig;

    /**
     * @Description: TODO(微信获取本地ToKen)
     */
    @RequestMapping(method = { RequestMethod.GET })
    public @ResponseBody
    String getLocalHostToKen(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr,
            HttpServletResponse response) {

        WeiXinResModel wxm = new WeiXinResModel(signature, timestamp, nonce,
                echostr, wexinConfig.loctoken);
        log.info("微信验证请求接入,请求参数:" + wxm.toString());
        String res = wxm.getSequenceFiles();
        if (signature.equals(WeiXinUtil.SHA1(res))) {
            log.info("签名:{" + signature + "},本地加签:{"
                    + WeiXinUtil.getHashSHA(res) + "}");
            return echostr;
        } else {
        }
        return "error";
    }
}
