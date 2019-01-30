package com.feng.security.social.wechat.config;


import com.feng.security.social.SecurityConstants;
import com.feng.security.social.SocialConnectView;
import com.feng.security.social.wechat.connect.WeixinConnectionFactory;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

//import cn.merryyou.logback.social.SocialAutoConfigurerAdapter;

/**
 * Created on 2018/1/11.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class WeixinAuthConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer configurer,
                                       Environment environment) {
        configurer.addConnectionFactory(createConnectionFactory());
    }

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        WeixinConnectionFactory weixinConnectionFactory = new WeixinConnectionFactory(SecurityConstants.DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID, SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_ID,
            SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_SECRET,wxMpService);
        return weixinConnectionFactory;
    }

    /**
     * /connect/weixin POST请求,绑定微信返回connect/weixinConnected视图
     * /connect/weixin DELETE请求,解绑返回connect/weixinConnect视图
     * @return
     */
    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new SocialConnectView();
    }

}
