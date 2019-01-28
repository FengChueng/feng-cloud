package com.feng.controller;

import com.feng.social.domain.GithubUserInfo;
import com.feng.social.domain.QQUser;
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
        GithubUserInfo user = (GithubUserInfo) userAuthentication.getPrincipal();
        model.addAttribute("username", user.getLogin());
        model.addAttribute("avatar", user.getAvatarUrl());
        return "user/user";
    }

}