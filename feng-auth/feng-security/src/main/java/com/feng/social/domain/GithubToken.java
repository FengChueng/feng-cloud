package com.feng.social.domain;

import lombok.Data;

@Data
public class GithubToken {

        /**
         * token
         */
        private String accessToken;

        /**
         * 权限范围
         */
        private String scope;

        /**
         * token类型：bearer
         */
        private String tokenType;
    }