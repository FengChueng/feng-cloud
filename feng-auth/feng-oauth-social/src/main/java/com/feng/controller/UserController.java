package com.feng.controller;

import com.feng.security.social.domain.GithubUserInfo;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

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

}