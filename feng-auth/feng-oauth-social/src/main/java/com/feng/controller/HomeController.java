package com.feng.controller;

import com.feng.security.social.github.GithubAuthenticationFilter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class HomeController {

    private final static String GITHUB_REDIRECT_URL = "http://www.lytxmd.top/login/github";
    private final static String WECHAT_REDIRECT_URL = "http://www.lytxmd.top/login/weixin";

    @Autowired
    private WxMpService wxMpService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model){
        //当有其他页面跳转时,有该参数
        String returnUrl = request.getHeader("Referer");
        String gitHubRedirectUrl = GITHUB_REDIRECT_URL;
        if(!StringUtils.isEmpty(returnUrl)){
            try {
                gitHubRedirectUrl = URLEncoder.encode(gitHubRedirectUrl + "?return_url="+returnUrl,"utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        String githubAuthUrl = String.format(GithubAuthenticationFilter.AUTHORIZE_URL,GithubAuthenticationFilter.clientId,
                gitHubRedirectUrl,"github");
        model.addAttribute("githubAuthUrl", githubAuthUrl);


        String wechatRedirectUrl = WECHAT_REDIRECT_URL;
        if(!StringUtils.isEmpty(returnUrl)){
            wechatRedirectUrl = wechatRedirectUrl + "?return_url="+returnUrl;
        }
        String wechatAuthUrl = wxMpService.oauth2buildAuthorizationUrl(wechatRedirectUrl, "snsapi_userinfo", "STATE");;
        model.addAttribute("wechatAuthUrl", wechatAuthUrl);
        return "login";
    }

}