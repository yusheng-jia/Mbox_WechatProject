package com.szty.wx.data.model;

/**
 * Created by Jia on 2017/3/17.
 */
public class BaseModel {
    /**
     * mysql 分页开始
     */
    private Integer limitStart;

    /**
     * 每页容量
     */
    private Integer pageSize;

    /**
     * 当前页码
     */
    private Integer pageNo;

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
