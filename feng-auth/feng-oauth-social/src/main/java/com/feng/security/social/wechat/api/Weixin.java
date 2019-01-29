package com.feng.security.social.wechat.api;

public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}