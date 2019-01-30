package com.feng.controller;

import com.feng.security.social.SecurityConstants;
import com.feng.security.social.SocialUserInfo;
import com.feng.security.social.domain.GithubUserInfo;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UsernamePasswordAuthenticationToken userAuthentication, Model model){
//        QQUser user = (QQUser) userAuthentication.getPrincipal();
//        model.addAttribute("username", user.getNickname());
//        model.addAttribute("avatar", user.getAvatar());
        Object principal = userAuthentication.getPrincipal();
        if(principal instanceof GithubUserInfo){
            GithubUserInfo user = (GithubUserInfo) userAuthentication.getPrincipal();
            model.addAttribute("username", user.getLogin());
            model.addAttribute("avatar", user.getAvatarUrl());
        }else if(principal instanceof WxMpUser){
            WxMpUser user = (WxMpUser) userAuthentication.getPrincipal();
            model.addAttribute("username", user.getNickname());
            model.addAttribute("avatar", user.getHeadImgUrl());
        }else{
            model.addAttribute("username", "游客");
        }
        return "user/user";
    }

    @PostMapping(SecurityConstants.DEFAULT_REGISTER_URL)
    public ModelAndView register(@RequestParam("username") String username,
                                 @RequestParam("password") String pasword, HttpServletRequest request, Map<String, Object> map) {
        log.info("【UserController】register username={},password={}", username, pasword);
//        //不管是注册用户还是绑定用户
//        providerSignInUtils.doPostSignUp(username, new ServletWebRequest(request));
        return new ModelAndView("login", map);
    }

    /**
     * 获取第三方用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("/social/info")
    public @ResponseBody
    SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        return userInfo;
    }

}