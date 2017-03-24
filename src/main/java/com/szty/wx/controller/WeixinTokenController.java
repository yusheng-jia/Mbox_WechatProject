package com.szty.wx.controller;

import com.szty.wx.model.WeiXinResModel;
import com.szty.wx.service.WeiXinBaseService;
import com.szty.wx.service.WeiXinDoPostService;
import com.szty.wx.util.WeiXinConfing;
import com.szty.wx.util.WeiXinUtil;
import com.szty.wx.util.WxMessageCodeUtil;
import com.szty.wx.util.WxMessageUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * Created by Jia on 2017/3/1.
 */
@Controller
@RequestMapping(value="/getToken")
public class WeixinTokenController {
    private static final Logger log = Logger.getLogger(WeixinTokenController.class);

    private static final String msgKey = "MsgType";

    @Autowired
    public WeiXinConfing wexinConfig;

    @Autowired
    public WeiXinDoPostService weiXinDoPostService;

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

    /**
     *
     * @Title: doPostHandle
     * @Description: TODO(微信借口主动回调)
     * @param @param requestBody
     * @param @return 设定文件
     * @return String 返回类型
     * @throws Exception
     */
    @RequestMapping(method = { RequestMethod.POST },produces="text/xml;charset=UTF-8")
    public @ResponseBody String doPostHandle(@RequestBody String requestBody)
            throws Exception {
        log.info("<===============微信回调======start=======================>");
        log.info("微信回调请求参数:=====>" + requestBody);
        Map<String, String> map = WxMessageUtil.parseStringToXml(requestBody);
        if (!map.isEmpty()) {
            // 依据消息类型调用不同接口
            int key = WxMessageCodeUtil.getName(map.get(msgKey));
            log.info("微信回调事件:=====[>>>>>>>>>" + key+"]===["+map.get(msgKey)+"]");
            String rspStr = "";
            switch (key) {
                case 1:
                    rspStr = weiXinDoPostService.doPostTextHandle(map);
                    break;
                case 2:
                    rspStr = weiXinDoPostService.doPostImageHandle(map);
                    break;
                case 3:
                    rspStr = weiXinDoPostService.doPostLinkHandle(map);
                    break;
                case 4:
                    rspStr = weiXinDoPostService.doPostLocationHandle(map);
                    break;
                case 5:
                    rspStr = weiXinDoPostService.doPostVoiceHandle(map);
                    break;
                case 6:
                    rspStr = weiXinDoPostService.doPostEventHandle(map);
                    break;
//                case 7:
//                    rspStr = weiXinDoPostService.doPostDeviceEvent(map);
//                    break;
//                case 8:
//                    rspStr = weiXinDoPostService.doPostDeviceText(map);
//                    break;
                default:
                    rspStr = weiXinDoPostService.doPostErrorHandle(map);
                    break;
            }
            log.info("微信回调=》返回参数：==>["+rspStr+"]");
            log.info("<===============微信回调======end=======================>");
            return rspStr;

        } else {
            // 返回错误文本接口
            log.info("<===============微信回调======end=============错误接口=========>");
            return weiXinDoPostService.doPostErrorHandle(map);
        }

    }

    /**
     * @Description: TODO(微信获取本地ToKen)
     */

    @RequestMapping(value = "/getBind",method = {RequestMethod.GET})
    public @ResponseBody String getLocalTokenBind(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr,
            HttpServletResponse response){
        WeiXinResModel wxm = new WeiXinResModel(signature, timestamp, nonce,
                echostr, wexinConfig.loctoken);
        log.info("微信设备功能验证请求接入,请求参数:" + wxm.toString());
        String res = wxm.getSequenceFiles();
        if (signature.equals(WeiXinUtil.SHA1(res))) {
            log.info("签名:{" + signature + "},本地加签:{"
                    + WeiXinUtil.getHashSHA(res) + "}");
            return echostr;
        } else {
        }
        return "error";
    }

    /**
     *
     * @Title: doPostHandle
     * @Description: TODO(微信借口主动回调)
     * @param @param requestBody
     * @param @return 设定文件
     * @return String 返回类型
     * @throws Exception
     */

    @RequestMapping(value = "/getBind",method = {RequestMethod.POST})
    public @ResponseBody String doDevicePostJson(@RequestParam String START_OBJECT)
        throws Exception{
            log.info("<===============设备功能微信回调======start=======================>");
            log.info("微信设备功能回调请求参数:=====>" + START_OBJECT);
            Map<String, String> map = WxMessageUtil.parseStringToXml(START_OBJECT);
            if (!map.isEmpty()) {
                // 依据消息类型调用不同接口
                int key = WxMessageCodeUtil.getName(map.get(msgKey));
                log.info("微信设备功能回调事件:=====[>>>>>>>>>" + key+"]===["+map.get(msgKey)+"]");
                String rspStr = "";
                switch (key) {
                    case 1:
                        rspStr = weiXinDoPostService.doPostTextHandle(map);
                        break;
                    case 2:
                        rspStr = weiXinDoPostService.doPostImageHandle(map);
                        break;
                    case 3:
                        rspStr = weiXinDoPostService.doPostLinkHandle(map);
                        break;
                    case 4:
                        rspStr = weiXinDoPostService.doPostLocationHandle(map);
                        break;
                    case 5:
                        rspStr = weiXinDoPostService.doPostVoiceHandle(map);
                        break;
                    case 6:
                        rspStr = weiXinDoPostService.doPostEventHandle(map);
                        break;
                    case 7:
                        rspStr = weiXinDoPostService.doPostEventHandle(map);
                        break;
//                    case 8:
//                        rspStr = weiXinDoPostService.doPostDeviceText(map);
//                        break;
                    default:
                        rspStr = weiXinDoPostService.doPostErrorHandle(map);
                        break;
                }
                log.info("微信设备功能回调=》返回参数：==>["+rspStr+"]");
                log.info("<===============微信设备功能回调======end=======================>");
                return rspStr;

            } else {
                // 返回错误文本接口
                log.info("<===============微信设备功能回调======end=============错误接口=========>");
                return weiXinDoPostService.doPostErrorHandle(map);
            }

        }

}
