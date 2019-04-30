package com.wx.test.controller;

import com.wx.test.common.pojo.WxResult;
import com.wx.test.pojo.WxAccessToken;
import com.wx.test.pojo.WxConstants;
import com.wx.test.service.AccessTokenService;
import com.wx.test.service.impl.AccessTokenServiceImpl;
import com.wx.test.utils.HttpClientUtil;
import com.wx.test.utils.JsonMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:wong
 */

@Controller
public class MenuController {

    @Autowired
    private WxConstants wxConstants;
    @Autowired
    private AccessTokenService accessTokenService;

    @RequestMapping("/createMenu")
    @ResponseBody
    public WxResult createMenu(){
        String menu =  "{\n" +
                "                \"button\":[\n" +
                "        {\n" +
                "            \"type\":\"click\",\n" +
                "                \"name\":\"审核\",\n" +
                "                \"key\":\"Teacher_Judge\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"click\",\n" +
                "            \"name\":\"评价\",\n" +
                "            \"key\":\"Teacher_Assess\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"click\",\n" +
                "                \"name\":\"查询\",\n" +
                "                \"key\":\"Teacher_Find\"\n" +
                "\n" +
                "        },\n" +
                "        ]}";

        WxAccessToken token = accessTokenService.getUpdateAccessToken();
        String url = WxConstants.createMenuURL.replace("ACCESS_TOKEN",token.getAccessToken());
        String s = HttpClientUtil.doPostJson(url, menu);
        Map<String,Object> map = JsonMapperUtil.parseJSONstr2Map(s);
        if((int)map.get("errcode") == 0) return WxResult.ok();
        else return WxResult.build(400, (String) map.get("errmsg"));
    }

    @RequestMapping("/deleteMenu")
    @ResponseBody
    public WxResult deleteMenu(){
        WxAccessToken accessToken = accessTokenService.getUpdateAccessToken();
        String url = WxConstants.deleteMunuURL.replace("ACCESS_TOKEN",accessToken.getAccessToken());
        String json = HttpClientUtil.doGet(url);
        Map<String,Object> map = JsonMapperUtil.parseJSONstr2Map(json);
        if ((int)map.get("errcode") == 0 ) return WxResult.ok();
        else return WxResult.build(400, (String) map.get("errmsg"));
    }
}
