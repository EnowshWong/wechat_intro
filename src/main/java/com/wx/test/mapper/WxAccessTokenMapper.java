package com.wx.test.mapper;

import com.wx.test.pojo.WxAccessToken;
import com.wx.test.pojo.WxAccessTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxAccessTokenMapper {
    int countByExample(WxAccessTokenExample example);

    int deleteByExample(WxAccessTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxAccessToken record);

    int insertSelective(WxAccessToken record);

    List<WxAccessToken> selectByExample(WxAccessTokenExample example);

    WxAccessToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxAccessToken record, @Param("example") WxAccessTokenExample example);

    int updateByExample(@Param("record") WxAccessToken record, @Param("example") WxAccessTokenExample example);

    int updateByPrimaryKeySelective(WxAccessToken record);

    int updateByPrimaryKey(WxAccessToken record);

    WxAccessToken getUpdateAccessToken();
}