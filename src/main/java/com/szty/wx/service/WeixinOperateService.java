package com.szty.wx.service;

import com.szty.wx.model.*;

/**
 * Created by Jia on 2017/3/17.
 */
public interface WeixinOperateService {
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
    public QrcodeMode setDirverQrcode();

    /**
     *
     * @Title: setAuthorizeDevice
     * @author mao.ru
     * @Description: TODO(设备新接口授权)
     * @param @return 设定文件
     * @return String 返回类型 1:成功2:失败
     * @throws
     */
    public String setAuthorizeDevice(ResDeviceModel resModel);

    /**
     *
     * @Title: setAuthorizeDevice
     * @author mao.ru
     * @Description: TODO(设备旧接口授权)
     * @param @return 设定文件
     * @return String 返回类型 1:成功2:失败
     * @throws
     */
    public String setOldAuthorizeDevice(ResDeviceModel resModel);

    /**
     *
     * @Title: setBindDevice
     * @author mao.ru
     * @Description: TODO(绑定设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setBindDevice(BindModel bindModel);

    /**
     *
     * @Title: setUnBindDevice
     * @author mao.ru
     * @Description: TODO(解绑设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setUnBindDevice(BindModel bindModel);

    /**
     *
     * @Title: setBindDevice
     * @author mao.ru
     * @Description: TODO(绑定设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setCompelBindDevice(BindModel bindModel);

    /**
     *
     * @Title: setUnBindDevice
     * @author mao.ru
     * @Description: TODO(解绑设备)
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public String setCompelUnBindDevice(BindModel bindModel);


    /**
     * 依据devi id 获取二维码
     * @Title: getCreateQrcode
     * @author mao.ru
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param createQrcode
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public CodeList getCreateQrcode(CreateQrcode createQrcode);
}
