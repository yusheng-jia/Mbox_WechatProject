package com.szty.wx.model;

/**
 * Created by Jia on 2017/3/2.
 * 微信Menu 中的Button实体类
 */
public class Button {
    private Button[] sub_button;// 二级菜单数组，个数应为1~5个
    private String type;
    private String name;

    public Button[] getSub_button() {
        return sub_button;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
