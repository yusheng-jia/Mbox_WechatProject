package com.szty.wx.dao;

import com.szty.wx.data.model.WxDevice;

import java.util.List;

/**
 * Created by Jia on 2017/3/17.
 */
public interface WxDeviceMapper {
    /**
     *
     * 添加
     *
     **/
    public void save( WxDevice wxDevice);

    /**
     *
     * 添加 （匹配有值的字段）
     *
     **/
    public void saveBySelective( WxDevice wxDevice);

    /**
     *
     * 批量新增
     *
     **/
    public void saveBatchWxDevice(List<WxDevice> list);

    /**
     *
     * 修改 （匹配有值的字段）
     *
     **/
    public int updateBySelective( WxDevice wxDevice);

    /**
     *
     * 主键ID修改
     *
     **/
    public int updateByPrimaryKey( WxDevice wxDevice);


    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    public WxDevice  selectByPrimaryKey (Long id );

    /**
     *
     * 多条数据
     *
     **/
    public List<WxDevice>  queryList (WxDevice wxDevice);

    /**
     *
     * 分页查询
     *
     **/
    public List<WxDevice>  queryPageList(WxDevice wxDevice);

    /**
     *
     * 分页查询
     *
     **/
    public Integer  queryPageCount (WxDevice wxDevice);
}
