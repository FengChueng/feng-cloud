package com.feng.security.social;

import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        filter.setPostFailureUrl("/login");

        Class<? extends AbstractAuthenticationProcessingFilter> aClass = filter.getClass();
        try {
            Method getSuccessHandler = aClass.getDeclaredMethod("getSuccessHandler", Void.class);
            getSuccessHandler.setAccessible(true);
            AuthenticationFailureHandler invoke = (AuthenticationFailureHandler) getSuccessHandler.invoke(filter);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return (T) filter;
    }
}
