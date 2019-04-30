package com.wx.test.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:wong
 */
//普通bean
@Component
public class WxConstants {

    public static final String accessTokenURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static final String createMenuURL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String deleteMunuURL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    @Value("${APPID}")
    private String APPID;
    @Value("${APPSecret}")
    private String APPSecret;

    public String getAPPID() {
        return APPID;
    }


    public String getAPPSecret() {
        return APPSecret;
    }
}
