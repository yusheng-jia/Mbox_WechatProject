package com.szty.wx.util;

import com.szty.wx.msg.model.Article;
import com.szty.wx.msg.model.MusicMessage;
import com.szty.wx.msg.model.NewsMessage;
import com.szty.wx.msg.model.TextMessage;
import com.szty.wx.service.impl.WeiXinDoPostServiceImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by Jia on 2017/3/6.
 */
public class WxMessageUtil {
    private static final Logger log = Logger
            .getLogger(WeiXinDoPostServiceImpl.class);
    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 微信运动事件 返回消息类型：hardware 微信运动事件
     */
    public static final String RESP_TYPE_HARDWARE = "hardware";

    /**
     * 微信运动事件 消息展示，目前支持myrank（排行榜）微信运动事件
     */
    public static final String RESP_TYPE_MessageView = "myrank";

    /**
     * 微信运动事件 消息点击动作，目前支持ranklist（点击跳转排行榜）
     */
    public static final String RESP_TYPE_MessageAction = "ranklist";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 事件类型：scan(用户已关注时的事件推送)
     */
    public static final String EVENT_TYPE_SCAN = "SCAN";

    public static final String EVENT_DEVICE_EVENT="device_event";

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseStringToXml(String request)
            throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        Document document = DocumentHelper.parseText(request);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        return map;
    }

    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request)
            throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        log.info("微信回调请求参数：====》[" + inputStream.toString() + "]");
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage
     *            文本消息对象 XStream是一个Java对象和XML相互转换的工具
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 音乐消息对象转换成xml
     *
     * @param musicMessage
     *            音乐消息对象
     * @return xml
     */
    public static String musicMessageToXml(MusicMessage musicMessage) {
        xstream.alias("xml", musicMessage.getClass());
        return xstream.toXML(musicMessage);
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage
     *            图文消息对象
     * @return xml
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new Article().getClass());
        return xstream.toXML(newsMessage);
    }

//    /**
//     *
//     * @Title: sociallyMessageToXml
//     * @Description: TODO(微信运动消息转成XML)
//     * @param @param socially
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public static String sociallyMessageToXml(Socially socially) {
//        xstream.alias("xml", socially.getClass());
//        xstream.alias("item", new HardWare().getClass());
//        return xstream.toXML(socially);
//
//    }
//
//    /**
//     *
//     * @Title: BindMessageToXml
//     * @Description: TODO(微信运动绑定消息转成XML)
//     * @param @param socially
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public static String bindMessageToXml(BindMsg bindMsg) {
//        xstream.alias("xml", bindMsg.getClass());
//        return xstream.toXML(bindMsg);
//
//    }
//
//
//    /**
//     *
//     * @Title: BindMessageToXml
//     * @Description: TODO(微信运动消息转成XML)
//     * @param @param socially
//     * @param @return 设定文件
//     * @return String 返回类型
//     * @throws
//     */
//    public static String derivceMessageToXml(DerviceMsgModel derviceMsgModel) {
//        xstream.alias("xml", derviceMsgModel.getClass());
//        return xstream.toXML(derviceMsgModel);
//
//    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}
