package com.wx.test.service.impl;

import com.wx.test.common.pojo.WxResult;
import com.wx.test.mapper.WxAccessTokenMapper;
import com.wx.test.pojo.WxAccessToken;
import com.wx.test.pojo.WxAccessTokenExample;
import com.wx.test.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author:wong
 */
@Service
@Transactional
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    WxAccessTokenMapper accessTokenMapper;

    @Override
    public WxAccessToken getUpdateAccessToken() {
        WxAccessToken updateAccessToken = accessTokenMapper.getUpdateAccessToken();
        return updateAccessToken;
    }

    @Override
    public WxResult createAccessToken(WxAccessToken wxAccessToken) {
        accessTokenMapper.insert(wxAccessToken);
        return WxResult.ok();
    }
}
