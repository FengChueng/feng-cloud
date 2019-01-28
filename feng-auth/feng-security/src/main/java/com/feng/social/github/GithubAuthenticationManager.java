package com.feng.social.github;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.social.domain.GithubUserInfo;
import com.feng.social.domain.QQUser;
import com.feng.uitls.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.feng.social.github.GithubAuthenticationFilter.clientId;


@Slf4j
public class GithubAuthenticationManager implements AuthenticationManager {
    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    /**
     * 获取 OpenID 及用户信息 的 API 地址
     */
    private final static String openIdUri = "https://api.github.com/user?access_token=%s";

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    private RestTemplate restTemplate;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        if (auth.getName() != null) {
            GithubUserInfo user = null;
            try {
                user = getOpenId(auth.getName());
            } catch (IOException e) {
                log.error("认证失败,根据token获取用户信息失败",e);
                throw new BadCredentialsException("Bad Credentials");
            }
            return new UsernamePasswordAuthenticationToken(user,
                    null, AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    private GithubUserInfo getOpenId(String accessToken) throws IOException {
        String url = String.format(openIdUri, accessToken);

        final GithubUserInfo userInfo = restTemplate.getForObject(url, GithubUserInfo.class);
        log.info("授权后 根据token获取用户信息:{}", JsonUtils.parse(userInfo));
        if (userInfo != null) {
            return userInfo;
        }
        return null;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}