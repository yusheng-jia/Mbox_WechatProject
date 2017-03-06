package com.szty.wx.service;

import com.szty.wx.model.Menu;
import com.szty.wx.model.RepMenuMode;

/**
 * Created by Jia on 2017/3/2.
 */
public interface WeiXinMenuService {

    /**
     * 创建菜单
     */
    public RepMenuMode createMenu();

    /**
     * 查询菜单
     */
    public Menu getMenu();

    /**
     * 删除菜单
     *
     * @return
     */
    public RepMenuMode delMenu();

}
