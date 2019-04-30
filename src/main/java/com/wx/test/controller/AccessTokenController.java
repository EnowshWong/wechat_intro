package com.wx.test.controller;

import com.wx.test.common.pojo.WxResult;
import com.wx.test.pojo.WxAccessToken;
import com.wx.test.pojo.WxConstants;
import com.wx.test.service.AccessTokenService;
import com.wx.test.utils.HttpClientUtil;
import com.wx.test.utils.JsonMapperUtil;
import com.wx.test.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * @author:wong
 */
@Controller
public class AccessTokenController {
    @Autowired
    WxConstants wxConstants;

    @Autowired
    private AccessTokenService accessTokenService;

    @RequestMapping("/getAccessToken")
    @ResponseBody
    public WxResult testAccessToken(){
        String url = WxConstants.accessTokenURL.replace("APPID",wxConstants.getAPPID()).replace(
                "APPSECRET",wxConstants.getAPPSecret()
        );

        String json = HttpClientUtil.doGet(url);
        //无法转化成功，因为json与java类不对应
        Map<String, Object> map = JsonMapperUtil.parseJSONstr2Map(json);
        WxAccessToken accessToken = new WxAccessToken();
        accessToken.setAccessToken((String) map.get("access_token"));
        int expiresIn = (int) map.get("expires_in");
        accessToken.setExpiresIn((long) expiresIn);
        accessToken.setCreated(new Date());
        //持久化
        WxResult wxResult = accessTokenService.createAccessToken(accessToken);
        return wxResult;
    }
}
