package com.szty.wx.dao;

import com.szty.wx.data.model.WxUser;

import java.util.List;

/**
 * Created by Jia on 2017/3/17.
 */
public interface WxUserMapper {
    /**
     *
     * 添加
     *
     **/
    public void save( WxUser wxUser);

    /**
     *
     * 添加 （匹配有值的字段）
     *
     **/
    public void saveBySelective( WxUser wxUser);

    /**
     *
     * 批量新增
     *
     **/
    public void saveBatchWxUser(List<WxUser> list);

    /**
     *
     * 修改 （匹配有值的字段）
     *
     **/
    public int updateBySelective( WxUser wxUser);

    /**
     *
     * 主键ID修改
     *
     **/
    public int updateByPrimaryKey( WxUser wxUser);


    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    public WxUser  selectByPrimaryKey (Long id );

    /**
     *
     * 多条数据
     *
     **/
    public List<WxUser>  queryList (WxUser wxUser);

    /**
     *
     * 分页查询
     *
     **/
    public List<WxUser>  queryPageList(WxUser wxUser);

    /**
     *
     * 分页查询
     *
     **/
    public Integer  queryPageCount (WxUser wxUser);

}
