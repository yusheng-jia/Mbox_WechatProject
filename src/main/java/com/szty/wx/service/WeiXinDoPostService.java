package com.szty.wx.service;

import java.util.Map;

/**
 * Created by Jia on 2017/3/6.
 */
public interface WeiXinDoPostService {
    /**
     * TEXT(1,"text")
     *
     * @Title: doPostTextHandle
     * @Description: TODO(请求消息类型：文本)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostTextHandle(Map<String, String> map);

    /**
     * IMAGE(2,"image")
     *
     * @Title: doPostImageHandle
     * @Description: TODO(请求消息类型：图片)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostImageHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostLinkHandle
     * @Description: TODO(请求消息类型：链接)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostLinkHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostLocationHandle
     * @Description: TODO(请求消息类型：地理位置)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */

    public String doPostLocationHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostVoiceHandle
     * @Description: TODO(请求消息类型：音频)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostVoiceHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostEventHandle
     * @Description: TODO(请求消息类型：推送)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostEventHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostSubscribeHandle
     * @Description: TODO(事件类型：subscribe(订阅))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostSubscribeHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostUnSubscribeHandle
     * @Description: TODO(事件类型：unsubscribe(取消订阅))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostUnSubscribeHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostClickHandle
     * @Description: TODO(事件类型：CLICK(自定义菜单点击事件))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostClickHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostScanHandle
     * @Description: TODO(事件类型：scan(用户已关注时的事件推送))
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostScanHandle(Map<String, String> map);

    /**
     *
     * @Title: doPostErrorHandle
     * @Description: TODO(异常和错误处理)
     * @param @param map
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String doPostErrorHandle(Map<String, String> map);

//    /**
//     *
//     * @Title: doPostDeviceEvent
//     * @Description: TODO(硬件事件 扫码绑定等)
//     * @param @param map
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public String doPostDeviceEvent(Map<String, String> map);
//
//
//    /**
//     *
//     * @Title: doPostDeviceEvent
//     * @Description: TODO(硬件扫码消息交互)
//     * @param @param map
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public String doPostDeviceText(Map<String, String> map);
}
