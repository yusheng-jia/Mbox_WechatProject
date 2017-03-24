package com.szty.wx.data.model;

/**
 * Created by Jia on 2017/3/17.
 */
public class WxUser extends BaseModel{
    /****/
    private Long id;
    /**微信用户Id**/
    private String openId;
    /****/
    private String mac;
    /**是否绑定1已绑定2未绑定**/
    private String state;
    /****/
    private String createTime;
    private String createTimeBegin;
    private String createTimeEnd;



    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }


    public void setOpenId(String openId){
        this.openId = openId;
    }

    public String getOpenId(){
        return this.openId;
    }


    public void setMac(String mac){
        this.mac = mac;
    }

    public String getMac(){
        return this.mac;
    }


    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }


    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public String getCreateTime(){
        return this.createTime;
    }

    public void setCreateTimeBegin (String createTimeBegin){
        this.createTimeBegin = createTimeBegin ;
    }

    public String getCreateTimeBegin (){
        return this.createTimeBegin;
    }

    public void setCreateTimeEnd (String createTimeEnd){
        this.createTimeEnd = createTimeEnd ;
    }

    public String getCreateTimeEnd (){
        return this.createTimeEnd;
    }
}
