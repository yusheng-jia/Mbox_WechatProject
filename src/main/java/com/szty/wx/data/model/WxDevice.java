package com.szty.wx.data.model;

/**
 * Created by Jia on 2017/3/17.
 */
public class WxDevice extends BaseModel{
    /****/
    private Long id;
    /**设备编号，微信分配**/
    private String deviceid;
    /****/
    private String qrticket;
    /**物理地址**/
    private String mac;
    /**是否授权1已授权2：未授权**/
    private String state;
    /**创建时间**/
    private String createTime;
    private String createTimeBegin;
    private String createTimeEnd;



    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }


    public void setDeviceid(String deviceid){
        this.deviceid = deviceid;
    }

    public String getDeviceid(){
        return this.deviceid;
    }


    public void setQrticket(String qrticket){
        this.qrticket = qrticket;
    }

    public String getQrticket(){
        return this.qrticket;
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
