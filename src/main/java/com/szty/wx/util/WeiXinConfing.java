package com.szty.wx.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jia on 2017/3/2.
 * 微信配置文件
 */
@Component
public class WeiXinConfing {
    @Value("#{wxconfing.weixin_granttype}")
    public String grantType; //获取acesstoken标致
    @Value("#{wxconfing.weixin_appid}")
    public String appid;//第三方用户唯一凭证
    @Value("#{wxconfing.weixin_appsecret}")
    public String appsecret;//第三方用户唯一凭证密钥，即appsecret
    @Value("#{wxconfing.weixin_locurl}")
    public String locurl;//第三方服务域名
    @Value("#{wxconfing.weixin_loctoken}")
    public String loctoken;//第三方服务token
    @Value("#{wxconfing.weixin_product_id}")
    public String productId;//设备id

    @Value("#{wxconfing.wx_menu_create_url}")
    public String menuCreateUrl;//创建菜单
    @Value("#{wxconfing.wx_menu_get_url}")
    public String menuGetUrl;//查询菜单
    @Value("#{wxconfing.wx_menu_delete_url}")
    public String menuDeleteUrl;//删除菜单
    @Value("#{wxconfing.wx_access_token_create_url}")
    public String accessTokenCreateUrl;//获取accessToKen
    @Value("#{wxconfing.wx_get_qrcode_url}")
    public String getQrcodeUrl;//第三方获取deviceid和设备二维码。
    @Value("#{wxconfing.wx_authorize_device_url}")
    public String authorizeDeviceUrl;//设备授权
    @Value("#{wxconfing.wx_bind_url}")
    public String bindUrl;//绑定
    @Value("#{wxconfing.wx_unbind_url}")
    public String unBindUrl;//解绑
    @Value("#{wxconfing.wx_compel_unbind_url}")
    public String compelUnBindUrl;//强制解绑
    @Value("#{wxconfing.wx_compel_bind_url}")
    public String compelBindUrl;//强制绑定
    @Value("#{wxconfing.wx_set_step}")
    public String setStepUrl;//上传当前步骤
    @Value("#{wxconfing.weixin_public_openId}")
    public String publicOpenId;//微信公众号
    @Value("#{wxconfing.wx_old_authorize_device_url}")
    public String oldAuthorizeDeviceUrl;//原始设备授权接口
    @Value("#{wxconfing.wx_create_qrcode}")
    public String createQrcode;//查询设备二维码
}
