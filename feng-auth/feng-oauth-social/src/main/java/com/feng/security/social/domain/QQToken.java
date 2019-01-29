package com.feng.security.social.domain;

import lombok.Data;

@Data
public class QQToken {

        /**
         * token
         */
        private String accessToken;

        /**
         * 有效期
         */
        private int expiresIn;

        /**
         * 刷新时用的 token
         */
        private String refresh_token;
    }