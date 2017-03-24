package com.szty.wx.service.impl;

import com.szty.wx.msg.model.TextMessage;
import com.szty.wx.service.WeiXinDoPostService;
import com.szty.wx.util.WxMenuClickUtil;
import com.szty.wx.util.WxMessageUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 微信回调处理类
 * Created by Jia on 2017/3/6.
 */
@Service
public class WeiXinDoPostServiceImpl implements WeiXinDoPostService{
    private static final Logger log = Logger
            .getLogger(WeiXinDoPostServiceImpl.class);

//    @Autowired
//    private UserStepMapper userStepMapper;

    /**
     * 1
     *
     * @Title: doPostTextHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：文本)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostTextHandle(Map<String, String> map) {
        return " ";

    }

    /**
     * 2
     *
     * @Title: doPostImageHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：图片)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostImageHandle(Map<String, String> map) {
        return " ";

    }

    /**
     * LINK(3,"link")
     *
     * @Title: doPostLinkHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：链接)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostLinkHandle(Map<String, String> map) {
        return " ";

    }

    /**
     * LOCATION(4,"location")
     *
     * @Title: doPostLocationHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：地理位置)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostLocationHandle(Map<String, String> map) {
        return " ";

    }

    /**
     * VOICE(5,"voice")
     *
     * @Title: doPostVoiceHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：音频)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostVoiceHandle(Map<String, String> map) {
        return " ";

    }

    /**
     * EVENT(6,"event") 待扩展，依据事件扩展
     *
     * @Title: doPostEventHandle
     * @author mao.ru
     * @Description: TODO(请求消息类型：推送)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostEventHandle(Map<String, String> map) {

        /**
         * SUBSCRIBE(7,"subscribe"),//,事件类型：subscribe(订阅)
         * UNSUBSCRIBE(8,"unsubscribe"),//,事件类型：unsubscribe(取消订阅)
         * CLICK(9,"CLICK"),//,事件类型：CLICK(自定义菜单点击事件) SCAN(10,"scan");//,
         * 事件类型：scan(用户已关注时的事件推送)
         */
        // String key = map.get("Event");
        log.info("微信回调来源：====> [自定义菜单事件]");
        String eventKey = map.get("EventKey");// 获取自定义菜单事件推送

        if(WxMenuClickUtil.EVENT_KEY_PLAY_MAIN.equals(eventKey)){
            String msg = "进入享听播放";
            return this.getTextMessageModel(msg, map);
        }

        if(WxMenuClickUtil.EVENT_KEY_SET_NETWORK.equals(eventKey)){
            String msg = "设置网络";
            return this.getTextMessageModel(msg, map);
        }

        if(WxMenuClickUtil.EVENT_KEY_SET_BRADN.equals(eventKey)){
            String msg = "品牌故事";
            return this.getTextMessageModel(msg, map);
        }

        if(WxMenuClickUtil.EVENT_KEY_SET_USAGE.equals(eventKey)){
            String msg = "使用说明";
            return this.getTextMessageModel(msg, map);
        }



//        if (MenuClickUtil.EVENT_KEY_SETPNOWCOUNT.equals(eventKey)) {
//            // UserStepExample example = new UserStepExample();
//            // example.setOrderByClause(" create_time desc ");
//            // example.createCriteria().andOpenidEqualTo().andCreateTimeGreaterThanOrEqualTo(DateUtil.getTodayDateStart());
//            // List<UserStep> list = userStepMapper.selectByExample(example);
//
//            // UserStep us = new UserStep();
//            // us.setOpenId(map.get("OpenID"));
//            // us.setCreateTimeBegin(DateUtil.DateToString(DateUtil.getTodayDateStart(),
//            // DateStyle.YYYY_MM_DD_HH_MM_SS));
//            // UserStep userStep = userStepMapper.queryListByMaxCreatTime(us);
//            UserStep userStep = null;
//            String msg = "";
//            if (userStep == null) {
//                msg = "您今天还没有同步运动数据，请同步！";
//            } else {
//                msg= "你还没偶";
//            }
//            return this.getTextMessageModel(msg, map);
//        }
//        if (MenuClickUtil.EVENT_KEY_SETPALLCOUNT.equals(eventKey)) {
//            return this.getSociallyMessageModel(map);
//        }
        return null;

    }

    /**
     *
     * @Title: doPostSubscribeHandle
     * @author mao.ru
     * @Description: TODO(事件类型：subscribe(订阅))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostSubscribeHandle(Map<String, String> map) {
        return " ";

    }

    /**
     *
     * @Title: doPostUnSubscribeHandle
     * @author mao.ru
     * @Description: TODO(事件类型：unsubscribe(取消订阅))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostUnSubscribeHandle(Map<String, String> map) {
        return " ";
    }

    /**
     *
     * @Title: doPostClickHandle
     * @author mao.ru
     * @Description: TODO(事件类型：CLICK(自定义菜单点击事件))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostClickHandle(Map<String, String> map) {
        return " ";

    }

    /**
     *
     * @Title: doPostScanHandle
     * @author mao.ru
     * @Description: TODO(事件类型：scan(用户已关注时的事件推送))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostScanHandle(Map<String, String> map) {
        return " ";

    }

    /**
     *
     * @Title: doPostErrorHandle
     * @author mao.ru
     * @Description: TODO(异常和错误处理)
     * @param @param map
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostErrorHandle(Map<String, String> map) {
        String msg = "服务器繁忙，请稍后再试！";
        String text = this.getTextMessageModel(msg, map);
        return text;
    }

//    public String doPostDeviceEvent(Map<String, String> map) {
//        log.info("微信回调来源：====> [微信运动]");
//        String eventKey = map.get("Event");
//        // 绑定事件
//        if (MenuClickUtil.EVENT_BIND.equals(eventKey)) {
//            return this.getBindMsgModel(map);
//        }
//        // 解绑事件
//        if (MenuClickUtil.EVENT_UNBIND.equals(eventKey)) {
//            return this.getBindMsgModel(map);
//        }
//        return null;
//    }

//    /**
//     * 微信消息交互
//     */
//    public String doPostDeviceText(Map<String, String> map) {
//
//        return this.getDerviceMsgModel(map);
//    }

    /**
     * 生成文本消息推送msg
     *
     * @Title: getMessageModel
     * @author mao.ru
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String getTextMessageModel(String msg, Map<String, String> map) {
        TextMessage textMsg = new TextMessage();
        textMsg.setContent(msg);
        textMsg.setCreateTime(new Date().getTime());
        textMsg.setFromUserName(map.get("ToUserName"));
        textMsg.setMsgType(WxMessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMsg.setToUserName(map.get("FromUserName"));
        String text = WxMessageUtil.textMessageToXml(textMsg);
        return text;
    }

//    /**
//     *
//     * @Title: getSociallyMessageModel
//     * @author mao.ru
//     * @Description: TODO(拼接微信运动返回消息)
//     * @param @param map
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public String getSociallyMessageModel(Map<String, String> map) {
//        Socially socially = new Socially();
//        socially.setToUserName(map.get("FromUserName"));
//        socially.setFromUserName(map.get("ToUserName"));
//        socially.setCreateTime(new Date().getTime());
//        socially.setMsgType(MessageUtil.RESP_TYPE_HARDWARE);
//        socially.setFuncFlag(0);
//        HardWare hardWare = new HardWare();
//        hardWare.setMessageAction(MessageUtil.RESP_TYPE_MessageAction);
//        hardWare.setMessageView(MessageUtil.RESP_TYPE_MessageView);
//        socially.setHardWare(hardWare);
//        String text = MessageUtil.sociallyMessageToXml(socially);
//        return text;
//    }
//
//    /**
//     *  微信硬件绑定返回消息
//     * @Title: getBindMsgModel
//     * @author mao.ru
//     * @Description: TODO(这里用一句话描述这个方法的作用)
//     * @param @param map
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public String getBindMsgModel(Map<String, String> map) {
//        BindMsg bindMsg = new BindMsg();
//        bindMsg.setToUserName(map.get("FromUserName"));
//        bindMsg.setFromUserName(map.get("ToUserName"));
//        bindMsg.setCreateTime(new Date().getTime());
//        bindMsg.setMsgType(MessageUtil.EVENT_DEVICE_EVENT);
//        bindMsg.setEvent(map.get("Event"));
//        bindMsg.setDeviceType(map.get("DeviceType"));
//        bindMsg.setSessionID(map.get("SessionID"));
//        bindMsg.setContent(Base64.getBase64("欢迎加入联络OS大家庭"));
//        String text = MessageUtil.bindMessageToXml(bindMsg);
//        return text;
//    }
//
//
//    public String getDerviceMsgModel(Map<String, String> map){
//        DerviceMsgModel derivceMsg = new DerviceMsgModel();
//        derivceMsg.setToUserName(map.get("FromUserName"));
//        derivceMsg.setFromUserName(map.get("ToUserName"));
//        derivceMsg.setCreateTime(new Date().getTime());
//        derivceMsg.setMsgType(MessageUtil.EVENT_DEVICE_EVENT);
//        derivceMsg.setDeviceType(map.get("DeviceType"));
//        derivceMsg.setSessionID(map.get("SessionID"));
//        derivceMsg.setContent(Base64.getBase64("上传成功"));
//        derivceMsg.setDeviceID(map.get("DeviceID"));
//        String text = MessageUtil.derivceMessageToXml(derivceMsg);
//        return text;
//    }
}
