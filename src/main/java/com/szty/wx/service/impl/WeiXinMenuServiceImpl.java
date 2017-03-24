package com.szty.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.szty.wx.model.Button;
import com.szty.wx.model.ClickButton;
import com.szty.wx.model.Menu;
import com.szty.wx.model.RepMenuMode;
import com.szty.wx.service.WeiXinBaseService;
import com.szty.wx.service.WeiXinMenuService;
import com.szty.wx.util.HttpUtil;
import com.szty.wx.util.WeiXinConfing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jia on 2017/3/2.
 */
@Service
public class WeiXinMenuServiceImpl implements WeiXinMenuService{
    private static final Logger log = Logger.getLogger(WeiXinMenuServiceImpl.class);

    @Autowired
    private WeiXinConfing wxconfig;

    @Autowired
    private WeiXinBaseService weiXinBaseService;

    public RepMenuMode createMenu() {
        String url = wxconfig.menuCreateUrl +"?access_token="+weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(setMenuData());
        log.info("创建菜单 请求参数：===》"+json);
        String res = HttpUtil.doPost(url, json);
        log.info("创建菜单：===》"+res);
        RepMenuMode rep = null;
        if (!res.isEmpty()) {
            rep = JSON.parseObject(res, RepMenuMode.class);
        }
        return rep;

    }

    public Menu getMenu() {
        String url = wxconfig.menuGetUrl + "?access_token=" + weiXinBaseService.getWeiXinToken();
        String res = HttpUtil.doGet(url);
        log.info("获取菜单：===》"+res);
        Menu rep = null;
        if (!res.isEmpty()) {
            rep = JSON.parseObject(res, Menu.class);
        }
        return rep;
    }

    public RepMenuMode delMenu() {

        String url = wxconfig.menuDeleteUrl + "?access_token=" + weiXinBaseService.getWeiXinToken();
        String res = HttpUtil.doGet(url);
        log.info("删除菜单：===》"+res);
        RepMenuMode rep = null;
        if (!res.isEmpty()) {
            rep = JSON.parseObject(res, RepMenuMode.class);
        }
        return rep;
    }

    public static Menu setMenuData() {


        Menu menu = new Menu();
        Button sub_button = new Button();

        ClickButton addNetwork = new ClickButton();
        addNetwork.setName("入网配置");
        addNetwork.setType("click");
        addNetwork.setKey("set_network");

        ClickButton ourBrand = new ClickButton();
        ourBrand.setName("品牌故事");
        ourBrand.setType("click");
        ourBrand.setKey("set_brand");

        ClickButton useAge = new ClickButton();
        useAge.setName("使用说明");
        useAge.setType("click");
        useAge.setKey("set_useage");

        sub_button.setSub_button(new Button[] { addNetwork, ourBrand,useAge});
        sub_button.setName("更多");

        ClickButton playMain = new ClickButton();
        playMain.setName("蔓生活");
        playMain.setType("click");
        playMain.setKey("play_main");

        menu.setButton(new Button[] { playMain, sub_button});
        return menu;
    }
}
