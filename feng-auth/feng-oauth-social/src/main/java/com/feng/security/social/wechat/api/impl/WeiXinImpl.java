package com.feng.security.social.wechat.api.impl;

import com.feng.security.social.wechat.api.Weixin;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.nio.charset.Charset;
import java.util.List;

public class WeiXinImpl extends AbstractOAuth2ApiBinding implements Weixin {

    private WxMpService wxMpService;

    public WeiXinImpl(String accessToken,WxMpService wxMpService) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.wxMpService = wxMpService;
    }

    /**
     * 获取用户信息
     *
     * @param openId
     * @return
     */
    @Override
    public WxMpUser getUserInfo(String openId) {

        try {
            WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openId);
            return wxMpUser;
        } catch (WxErrorException e) {
            return null;
        }
    }

    /**
     * 使用utf-8 替换默认的ISO-8859-1编码
     * @return
     */
    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
        messageConverters.remove(0);
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        return messageConverters;
    }
}