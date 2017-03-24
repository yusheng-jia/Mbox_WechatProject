package com.szty.wx.util;

/**
 * Created by Jia on 2017/3/6.
 */
public enum WxMessageCodeUtil {
    TEXT(1,"text"),//请求消息类型：文本
    IMAGE(2,"image"),//请求消息类型：图片
    LINK(3,"link"),//请求消息类型：链接
    LOCATION(4,"location"),//请求消息类型：地理位置
    VOICE(5,"voice"),//, 请求消息类型：音频
    EVENT(6,"event"),//,请求消息类型：推送
    DEVICE_EVENT(7,"device_event"),//微信硬件绑定
    DEVICE_TEXT(8,"device_text");//微信硬件消息接受类型
    /*SUBSCRIBE(7,"subscribe"),//,事件类型：subscribe(订阅)
    UNSUBSCRIBE(8,"unsubscribe"),//,事件类型：unsubscribe(取消订阅)
    CLICK(9,"CLICK"),//,事件类型：CLICK(自定义菜单点击事件)
    SCAN(10,"scan");//, 事件类型：scan(用户已关注时的事件推送)
*/
    private int codeId;
    private String codeName;

    // 普通方法
    public static int getName(String index) {
        for (WxMessageCodeUtil msg : WxMessageCodeUtil.values()) {
            if (index.equals(msg.getCodeName())) {
                return msg.getCodeId();
            }
        }
        return 0;
    }

    private WxMessageCodeUtil(int codeId, String codeName) {
        this.codeId = codeId;
        this.codeName = codeName;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
