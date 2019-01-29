package com.feng.config;


import me.chanjar.weixin.mp.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.log.LogHandler;

import javax.annotation.Resource;

/**
 * wechat mp configuration
 *
 * @author Binary Wang(https://github.com/binarywang)
 */
@Configuration
@ConditionalOnClass(WxMpService.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpConfiguration {

    @Autowired
    private TextHandler textHandler;

    @Autowired
    private WechatMpProperties properties;
    @Resource
    private RedisProperties redisProperties;

//    @Bean
//    public JedisPool redisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
//        jedisPoolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait());
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(),
//                redisProperties.getTimeout(), redisProperties.getPassword());
//        return jedisPool;
//    }

//    @Bean("wxMpInRedisConfigStorage")
//    @ConditionalOnMissingBean
//    public WxMpConfigStorage configRedisStorage(JedisPool jedisPool) {
//        WxMpInRedisConfigStorage configStorage = new WxMpInRedisConfigStorage(jedisPool);
//        configStorage.setAppId(this.properties.getAppId());
//        configStorage.setSecret(this.properties.getSecret());
//        configStorage.setToken(this.properties.getToken());
//        configStorage.setAesKey(this.properties.getAesKey());
//        return configStorage;
//    }

    @Bean("wxMpInMemoryConfigStorage")
    @ConditionalOnMissingBean
    public WxMpConfigStorage configStorage() {
        WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId(this.properties.getAppId());
        configStorage.setSecret(this.properties.getSecret());
        configStorage.setToken(this.properties.getToken());
        configStorage.setAesKey(this.properties.getAesKey());
        return configStorage;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxMpService wxMpService(@Qualifier("wxMpInMemoryConfigStorage") WxMpConfigStorage configStorage) {
//    public WxMpService wxMpService(WxMpConfigStorage configStorage) {
        // WxMpService wxMpService = new
        // me.chanjar.weixin.mp.api.impl.okhttp.WxMpServiceImpl();
        // WxMpService wxMpService = new
        // me.chanjar.weixin.mp.api.impl.jodd.WxMpServiceImpl();
        // WxMpService wxMpService = new
        // me.chanjar.weixin.mp.api.impl.apache.WxMpServiceImpl();
        WxMpService wxMpService = new me.chanjar.weixin.mp.api.impl.WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);
        return wxMpService;
    }

    @Bean
    public WxMpMessageRouter router(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);
//         newRouter.rule().async(false).msgType(XmlMsgType.TEXT).handler(textHandler).end();
        // 默认
//        newRouter.rule().async(false).handler(msgHandler).end();
        newRouter.rule().async(false).handler(textHandler).end();
        return newRouter;
    }
}
