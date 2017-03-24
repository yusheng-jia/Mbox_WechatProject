package com.szty.wx.msg.model;

/**
 * Created by Jia on 2017/3/6.
 */
public class TextMessage extends BaseMessage{
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
