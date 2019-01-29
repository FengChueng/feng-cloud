package com.feng.config;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts.XmlMsgType;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 
 * @Description:普通文本消息
 *
 * @Package: com.txmd.common.service.weixin.handler
 * @author: zyl
 * @date: 2018年7月11日 下午3:34:27
 */
@Slf4j
@Component
public class TextHandler implements WxMpMessageHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService weixinService,
            WxSessionManager sessionManager) {
        if (!wxMessage.getMsgType().equals(XmlMsgType.TEXT)) {
            // TODO 可以选择将消息保存到本地
            log.info("收到消息类型:{} 事件类型：{} 内容:{}",wxMessage.getMsgType(),wxMessage.getEvent(), wxMessage.toString());
            return null;
        }
        // 接收用户发送的文本消息内容
        String content = wxMessage.getContent();
        return WxMpXmlOutMessage.TEXT().content(content).build();
    }
}
