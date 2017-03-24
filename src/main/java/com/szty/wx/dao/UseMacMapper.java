package com.szty.wx.dao;

import com.szty.wx.data.model.UserMac;

import java.util.List;

/**
 * Created by Jia on 2017/3/17.
 */
public interface UseMacMapper {

    /**
     *
     * 添加
     *
     **/
    public void save( UserMac userMac);

    /**
     *
     * 添加 （匹配有值的字段）
     *
     **/
    public void saveBySelective( UserMac userMac);

    /**
     *
     * 批量新增
     *
     **/
    public void saveBatchUserMac(List<UserMac> list);

    /**
     *
     * 修改 （匹配有值的字段）
     *
     **/
    public int updateBySelective( UserMac userMac);

    /**
     *
     * 主键ID修改
     *
     **/
    public int updateByPrimaryKey( UserMac userMac);


    /**
     *
     * 查询（根据主键ID查询）
     *
     **/
    public UserMac  selectByPrimaryKey (Long id );

    /**
     *
     * 多条数据
     *
     **/
    public List<UserMac>  queryList (UserMac userMac);

    /**
     *
     * 分页查询
     *
     **/
    public List<UserMac>  queryPageList(UserMac userMac);

    /**
     *
     * 分页查询
     *
     **/
    public Integer  queryPageCount (UserMac userMac);

}
