package com.feng.security.social.github.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class GitHubUser implements Serializable {

    private final long id;

    private final String url;

    private final String login;

    private final String avatarUrl;

    private final String gravatarId;

    private String name;

    private String email;

    public GitHubUser(long id, String url, String login, String avatarUrl, String gravatarId) {
        this.id = id;
        this.url = url;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
    }
}