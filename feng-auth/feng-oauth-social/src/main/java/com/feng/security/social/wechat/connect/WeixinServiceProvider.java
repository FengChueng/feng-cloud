package com.feng.security.social.wechat.connect;

import com.feng.security.social.wechat.api.Weixin;
import com.feng.security.social.wechat.api.impl.WeiXinImpl;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class WeixinServiceProvider extends AbstractOAuth2ServiceProvider<Weixin> {

    private WxMpService wxMpService;
    /**
     * 微信获取授权码的url
     */
    private static final String WEIXIN_URL_AUTHORIZE = "https://open.weixin.qq.com/connect/qrconnect";
    /**
     * 微信获取accessToken的url(微信在获取accessToken时也已经返回openId)
     */
    private static final String WEIXIN_URL_ACCESS_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";

    public WeixinServiceProvider(String appId, String appSecret,WxMpService wxMpService) {
        super(new WeixinOAuth2Template(appId, appSecret, WEIXIN_URL_AUTHORIZE, WEIXIN_URL_ACCESS_TOKEN));
        this.wxMpService = wxMpService;
    }

    @Override
    public Weixin getApi(String accessToken) {
        return new WeiXinImpl(accessToken,wxMpService);
    }

    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }
}