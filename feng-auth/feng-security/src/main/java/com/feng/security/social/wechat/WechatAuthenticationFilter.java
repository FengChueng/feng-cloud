package com.feng.security.social.wechat;

import com.feng.uitls.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class WechatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * client_id 由腾讯提供
     */
    public static final String clientId = "wxc309f7b7388d3ca9";
    private final static String clientSecret = "31e197d6d14ae223a3e9cafea4b966b9";

    private final static String CODE = "code";
    public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&connect_redirect=1#wechat_redirect";
    /**
     * 获取 Token 的 API
     */
    private final static String accessTokenUri = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    /**
     * grant_type 由腾讯提供
     */
    private final static String grantType = "authorization_code";
    /**
     * redirect_uri 腾讯回调地址
     */
    private final static String redirectUri = "http://www.lytxmd.top/login/github";

    /**
     * 获取 OpenID 的 API 地址
     */
    private final static String openIdUri = "https://api.github.com/user?access_token=%s";

    private static final String GITHUB_STATE = "use-login";
    /**
     * 获取 token 的地址拼接
     */
    private final static String TOKEN_ACCESS_API =
            "%s?grant_type=%s&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s";

    private WxMpService wxMpService;

    public WechatAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException, IOException, ServletException {
        String redirectUrl = redirectUri;
        String code = request.getParameter(CODE);

        if(StringUtils.isEmpty(code)){
            return null;
        }

        log.info("授权后 code:{}", code);
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            log.info("授权后 token:{}", JsonUtils.parse(wxMpOAuth2AccessToken));
            if (wxMpOAuth2AccessToken != null) {
                String accessToken = wxMpOAuth2AccessToken.getAccessToken();
                String openId = wxMpOAuth2AccessToken.getOpenId();
                int expiresIn = wxMpOAuth2AccessToken.getExpiresIn();
                String refreshToken = wxMpOAuth2AccessToken.getRefreshToken();
                String scope = wxMpOAuth2AccessToken.getScope();
                String unionId = wxMpOAuth2AccessToken.getUnionId();
                log.info("授权后 accessToken:{},openId:{},scope", accessToken,openId,scope);
                if (accessToken != null) {
                    // 生成验证 authenticationToken
                    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(accessToken, openId);
                    // 返回验证结果
                    return this.getAuthenticationManager().authenticate(authRequest);
                }
            }
        } catch (WxErrorException e) {
            log.error("根据code获取openId失败:",e);
        }
        return null;
    }

    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

}