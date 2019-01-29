package com.feng.security.social.wechat;

import com.feng.uitls.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class WechatAuthenticationManager implements AuthenticationManager {
    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    private WxMpService wxMpService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getName() != null && auth.getCredentials() != null) {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
            wxMpOAuth2AccessToken.setAccessToken(auth.getName());
            wxMpOAuth2AccessToken.setOpenId((String) auth.getCredentials());
            try {
                WxMpUser wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                log.info("根据token和openid获取:{}", JsonUtils.parse(wxMpUser));
                WxMpUser wxMpUser1 = wxMpService.getUserService().userInfo(wxMpOAuth2AccessToken.getOpenId());
                log.info("根据openid获取:{}", JsonUtils.parse(wxMpUser1));
                //可进行绑定操作,将微信账号和系统账号进行关联
                return new UsernamePasswordAuthenticationToken(wxMpUser,
                    null, AUTHORITIES);
            } catch (WxErrorException e) {
                log.error("根据token和openid获取用户信息失败:{}",e);
            }
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

}