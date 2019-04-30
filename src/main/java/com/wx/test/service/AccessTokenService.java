package com.wx.test.service;

import com.wx.test.common.pojo.WxResult;
import com.wx.test.pojo.WxAccessToken;

/**
 * @author:wong
 */
public interface AccessTokenService {
    WxAccessToken getUpdateAccessToken();
    WxResult createAccessToken(WxAccessToken wxAccessToken);
}
