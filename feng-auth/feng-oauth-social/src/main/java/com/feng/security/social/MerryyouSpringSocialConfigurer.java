package com.feng.security.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 继承默认的社交登录配置，加入自定义的后处理逻辑
 * Created on 2018/1/8 0008.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class MerryyouSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public MerryyouSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        filter.setSignupUrl("/socialRegister");
        filter.setPostLoginUrl("http://www.lytxmd.com/");
        filter.setPostLoginUrl("http://www.lytxmd.com/");
        filter.setPostFailureUrl("/login");

        return (T) filter;
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        ApplicationContext applicationContext = http.getSharedObject(ApplicationContext.class);
//        UsersConnectionRepository usersConnectionRepository = getDependency(applicationContext, UsersConnectionRepository.class);
//        SocialAuthenticationServiceLocator authServiceLocator = getDependency(applicationContext, SocialAuthenticationServiceLocator.class);
//        SocialUserDetailsService socialUsersDetailsService = getDependency(applicationContext, SocialUserDetailsService.class);
//
//        SocialAuthenticationFilter filter = new SocialAuthenticationFilter(
//            http.getSharedObject(AuthenticationManager.class),
//            userIdSource != null ? userIdSource : new AuthenticationNameUserIdSource(),
//            usersConnectionRepository,
//            authServiceLocator);
//
//        RememberMeServices rememberMe = http.getSharedObject(RememberMeServices.class);
//        if (rememberMe != null) {
//            filter.setRememberMeServices(rememberMe);
//        }
//
//        if (postLoginUrl != null) {
//            filter.setPostLoginUrl(postLoginUrl);
//            filter.setAlwaysUsePostLoginUrl(alwaysUsePostLoginUrl);
//        }
//
//        if (postFailureUrl != null) {
//            filter.setPostFailureUrl(postFailureUrl);
//        }
//
//        if (signupUrl != null) {
//            filter.setSignupUrl(signupUrl);
//        }
//
//        if (connectionAddedRedirectUrl != null) {
//            filter.setConnectionAddedRedirectUrl(connectionAddedRedirectUrl);
//        }
//
//        if (defaultFailureUrl != null) {
//            filter.setDefaultFailureUrl(defaultFailureUrl);
//        }
//
//        http.authenticationProvider(
//            new SocialAuthenticationProvider(usersConnectionRepository, socialUsersDetailsService))
//            .addFilterBefore(postProcess(filter), AbstractPreAuthenticatedProcessingFilter.class);
//    }

}
