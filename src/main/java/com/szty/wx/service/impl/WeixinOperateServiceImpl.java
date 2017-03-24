package com.szty.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.szty.wx.dao.WxDeviceMapper;
import com.szty.wx.data.model.WxDevice;
import com.szty.wx.model.*;
import com.szty.wx.service.WeiXinBaseService;
import com.szty.wx.service.WeixinOperateService;
import com.szty.wx.util.DateStyle;
import com.szty.wx.util.DateUtil;
import com.szty.wx.util.HttpUtil;
import com.szty.wx.util.WeiXinConfing;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Jia on 2017/3/17.
 */
@Service
public class WeixinOperateServiceImpl implements WeixinOperateService{

    private static final Logger logger = Logger.getLogger(WeixinOperateServiceImpl.class);

    @Autowired
    private WeiXinConfing weiXinConfing;

    @Autowired
    private WeiXinBaseService weiXinBaseService;

    @Autowired
    private WxDeviceMapper wxDeviceMapper;



    /**
     * 备注 deviceid由微信服务器分配
     *
     * @Title: getQrcode
     * @author mao.ru
     * @Description: TODO(第三方获取deviceid和设备二维码)
     * @param @return 设定文件
     * @return void 返回类型
     * @throws
     */
    public QrcodeMode setDirverQrcode() {

        String url = weiXinConfing.getQrcodeUrl+"?access_token="+weiXinBaseService.getWeiXinToken()+
                "&product_id="+weiXinConfing.productId;

        String res = HttpUtil.doGet(url);
        logger.info("第三方获取deviceid和设备二维码：===》[" + res + "]");
        QrcodeMode rep = null;
        if (res != null){
            rep = JSON.parseObject(res,QrcodeMode.class);
        }else{
            if(rep.getBase_resp().getErrcode().equals("0")){
                WxDevice wxDevice  = new WxDevice();
                wxDevice.setCreateTime(DateUtil.DateToString(new Date(), DateStyle.YYYY_MM_DD_HH_MM));
                wxDevice.setDeviceid(rep.getDeviceid());
                wxDevice.setQrticket(rep.getQrticket());
                wxDevice.setState("2");
                wxDeviceMapper.save(wxDevice);
            }
        }

        return rep;

    }

    /**
     *
     * @Title: setAuthorizeDevice
     * @author mao.ru
     * @Description: TODO(设备新接口授权)
     * @param @return 设定文件
     * @return String 返回类型 1:成功2:失败
     * @throws
     */
    public String setAuthorizeDevice(ResDeviceModel resModel) {
        String url = weiXinConfing.authorizeDeviceUrl+"?access_token="+weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(resModel);
        String res = HttpUtil.doPost(url,json);
        logger.info("第三方授权设备 新接口：===》[" + res + "]");
        AuthorizeModel rep = null;
        if(!res.isEmpty()){
            rep = JSON.parseObject(res,AuthorizeModel.class);
            if(rep == null || rep.getResp().isEmpty()
                    || !rep.getResp().get(0).getErrcode().equals("0")){
                return "2";
            }
        }
            return "1";
    }

    /**
     *
     * @Title: setAuthorizeDevice
     * @author mao.ru
     * @Description: TODO(设备旧接口授权)
     * @param @return 设定文件
     * @return String 返回类型 1:成功2:失败
     * @throws
     */
    public String setOldAuthorizeDevice(ResDeviceModel resModel) {
        String url = weiXinConfing.authorizeDeviceUrl + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        // resModel = this.toResDeviceModel();
        String json = JSON.toJSONString(resModel);
        String res = HttpUtil.doPost(url, json);
        logger.info("授权原始接口：===》[" + res + "]");
        AuthorizeModel rep = null;
        if (!res.isEmpty()) {
            rep = JSON.parseObject(res, AuthorizeModel.class);
        }
        if (rep == null || rep.getResp().isEmpty()
                || !rep.getResp().get(0).getErrcode().equals("0")) {
            return "2";
        }
        return "1";
    }

    /**
     *
     * @Title: setBindDevice
     * @author mao.ru
     * @Description: TODO(绑定设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setBindDevice(BindModel bindModel) {
        String url = weiXinConfing.bindUrl + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(bindModel);
        String res = HttpUtil.doPost(url, json);
        logger.info("绑定：===》[" + res + "]");
        return res;
    }

    /**
     *
     * @Title: setUnBindDevice
     * @author mao.ru
     * @Description: TODO(解绑设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setUnBindDevice(BindModel bindModel){
        String url = weiXinConfing.unBindUrl + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(bindModel);
        String res = HttpUtil.doPost(url, json);
        logger.info("解绑：===》[" + res + "]");
        return res;
    }

    /**
     *
     * @Title: setBindDevice
     * @author mao.ru
     * @Description: TODO(绑定设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setCompelBindDevice(BindModel bindModel) {
        String url = weiXinConfing.compelBindUrl + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(bindModel);
        String res = HttpUtil.doPost(url, json);
        logger.info("强制绑定：===》[" + res + "]");
        return res;
    }

    /**
     *
     * @Title: setUnBindDevice
     * @author mao.ru
     * @Description: TODO(解绑设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setCompelUnBindDevice(BindModel bindModel){
        String url = weiXinConfing.compelUnBindUrl + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(bindModel);
        String res = HttpUtil.doPost(url, json);
        logger.info("强制解绑：===》[" + res + "]");
        return res;
    }


    /**
     * 依据device id 获取二维码
     * @Title: getCreateQrcode
     * @author mao.ru
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param createQrcode
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public CodeList getCreateQrcode(CreateQrcode createQrcode){
        String url = weiXinConfing.createQrcode + "?access_token="
                + weiXinBaseService.getWeiXinToken();
        String json = JSON.toJSONString(createQrcode);
        String res = HttpUtil.doPost(url, json);
        CodeList rep = null;
        if (!res.isEmpty()) {
            rep = JSON.parseObject(res, CodeList.class);
        }
        return rep;
    }
}
