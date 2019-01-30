package com.feng.security.social.wechat.api;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface Weixin {
    WxMpUser getUserInfo(String openId);
}