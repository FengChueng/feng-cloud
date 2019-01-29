package com.feng.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feng.security.social.github.GithubAuthenticationFilter;
import com.feng.security.social.github.GithubAuthenticationManager;
import com.feng.security.social.qq.QQAuthenticationFilter;
import com.feng.security.social.qq.QQAuthenticationManager;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WxMpService wxMpService;

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(120000);
        List<HttpMessageConverter<?>> messageConverters = new LinkedList<>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<Source>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        RestTemplate restTemplate=new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//            .exceptionHandling().authenticationEntryPoint(null).accessDeniedHandler(null).and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/user/**").hasRole("USER")
            .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/user")
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        // 在 UsernamePasswordAuthenticationFilter 前添加 WechatAuthenticationFilter
        http.addFilterAt(qqAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAt(githubAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//        http.addFilterAt(wechatAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    /**
     * 自定义 QQ登录 过滤器
     */
    private QQAuthenticationFilter qqAuthenticationFilter(){
        QQAuthenticationFilter authenticationFilter = new QQAuthenticationFilter("/login/qq");
        SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setAlwaysUseDefaultTargetUrl(true);
        successHandler.setDefaultTargetUrl("/user");
        authenticationFilter.setAuthenticationManager(new QQAuthenticationManager());
        authenticationFilter.setAuthenticationSuccessHandler(successHandler);
        return authenticationFilter;
    }

    private GithubAuthenticationFilter githubAuthenticationFilter(){
        GithubAuthenticationFilter authenticationFilter = new GithubAuthenticationFilter( "/login/github");
        SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setAlwaysUseDefaultTargetUrl(false);
//        successHandler.setDefaultTargetUrl("/user");
        successHandler.setDefaultTargetUrl("http://www.lytxmd.top/");
        successHandler.setTargetUrlParameter("return_url");
        final GithubAuthenticationManager authenticationManager = new GithubAuthenticationManager();
        authenticationManager.setRestTemplate(restTemplate);
        authenticationFilter.setAuthenticationManager(authenticationManager);
        authenticationFilter.setAuthenticationSuccessHandler(successHandler);
        authenticationFilter.setObjectMapper(objectMapper);
        authenticationFilter.setRestTemplate(restTemplate);
        return authenticationFilter;
    }

}