package com.feng.security.social.github.api;

public interface GitHub {
    GitHubUser getUserInfo(String openId);
}