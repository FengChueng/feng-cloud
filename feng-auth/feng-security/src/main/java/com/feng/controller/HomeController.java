package com.feng.controller;

import com.feng.social.github.GithubAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class HomeController {



    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model){
        //当有其他页面跳转时,有该参数
        String returnUrl = request.getHeader("Referer");
        String redirectUrl = "http://www.lytxmd.top/login/github";
        if(!StringUtils.isEmpty(returnUrl)){
            try {
                redirectUrl = URLEncoder.encode(redirectUrl + "?return_url="+returnUrl,"utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        String githubAuthUrl = String.format(GithubAuthenticationFilter.AUTHORIZE_URL,GithubAuthenticationFilter.clientId,
                redirectUrl,"github");
        model.addAttribute("githubAuthUrl", githubAuthUrl);
        return "login";
    }

}