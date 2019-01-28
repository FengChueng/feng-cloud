package com.feng.social.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.social.domain.GithubToken;
import com.feng.social.domain.GithubUserInfo;
import com.feng.uitls.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

@Slf4j
public class GithubAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * client_id 由腾讯提供
     */
    public static final String clientId = "ff9acd589f1aa1361a30";
    private final static String CODE = "code";
    public static final String AUTHORIZE_URL = "https://github" +
            ".com/login/oauth/authorize?client_id=%s&redirect_uri=%s&state=%s";
    /**
     * 获取 Token 的 API
     */
    private final static String accessTokenUri = "https://github" +
            ".com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s&redirect_uri=%s&state=%s";
    /**
     * grant_type 由腾讯提供
     */
    private final static String grantType = "authorization_code";
    /**
     * client_secret 由腾讯提供
     */
    private final static String clientSecret = "d5c4ef7395f6bd647b55cc83755927e4a15129f3";

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
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public GithubAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
            AuthenticationException, IOException, ServletException {
        String redirectUrl = redirectUri;
        String code = request.getParameter(CODE);
//        String returnUrl = request.getParameter("return_url");
//        if(!StringUtils.isEmpty(returnUrl)){
//            redirectUrl = URLEncoder.encode(redirectUrl + "?return_url="+returnUrl,"utf-8");
//        }
        log.info("授权后 code:{}", code);
        String tokenAccessApi = String.format(accessTokenUri, clientId, clientSecret, code, redirectUrl, GITHUB_STATE);
//        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(tokenAccessApi);
//        URI uri = builder.build().encode().toUri();
        GithubToken githubToken = this.getToken(tokenAccessApi);
        log.info("授权后 token:{}", JsonUtils.parse(githubToken));
        if (githubToken != null) {
            String accessToken = githubToken.getAccessToken();
            log.info("授权后 accessToken:{}", accessToken);
            if (accessToken != null) {
                // 生成验证 authenticationToken
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(accessToken, null);
                // 返回验证结果
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }
        return null;
    }

    private GithubToken getToken(String tokenAccessApi) throws IOException {

        final String tokenResult = restTemplate.getForObject(tokenAccessApi, String.class);
        if(tokenResult==null){
            log.error("获取token失败 null");
            return null;
        }
        if(!tokenResult.contains("access_token")){
            log.error("获取token失败:{}",tokenResult);
            return null;
        }

        String[] results = tokenResult.split("&");
        if (results.length != 3) {
            log.error("获取token失败,无效token:{}",tokenResult);
            return null;
        }
        GithubToken githubToken = new GithubToken();
        String accessToken = results[0].replace("access_token=", "");
        final String scope = results[1].substring(results[1].indexOf("=") + 1, results[1].length());
        final String token_type = results[2].substring(results[2].indexOf("=") + 1, results[2].length());
        githubToken.setAccessToken(accessToken);
        githubToken.setScope(scope);
        githubToken.setTokenType(token_type);
        return githubToken;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}