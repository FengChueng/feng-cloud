package com.feng.security.social.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2019/1/28.
 */
public class GithubUserInfo {

    /**
     * login : FengChueng
     * id : 25821572
     * node_id : MDQ6VXNlcjI1ODIxNTcy
     * avatar_url : https://avatars2.githubusercontent.com/u/25821572?v=4
     * gravatar_id :
     * url : https://api.github.com/users/FengChueng
     * html_url : https://github.com/FengChueng
     * followers_url : https://api.github.com/users/FengChueng/followers
     * following_url : https://api.github.com/users/FengChueng/following{/other_user}
     * gists_url : https://api.github.com/users/FengChueng/gists{/gist_id}
     * starred_url : https://api.github.com/users/FengChueng/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/FengChueng/subscriptions
     * organizations_url : https://api.github.com/users/FengChueng/orgs
     * repos_url : https://api.github.com/users/FengChueng/repos
     * events_url : https://api.github.com/users/FengChueng/events{/privacy}
     * received_events_url : https://api.github.com/users/FengChueng/received_events
     * type : User
     * site_admin : false
     * name :
     * company :
     * blog :
     * location :
     * email :
     * hireable : null
     * bio : null
     * public_repos : 63
     * public_gists : 0
     * followers : 2
     * following : 3
     * created_at : 2017-02-16T13:50:10Z
     * updated_at : 2019-01-18T10:05:23Z
     */

    private String login;
    private int id;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("gravatar_id")
    private String gravatarId;
    private String url;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("followers_url")
    private String followersUrl;
    @JsonProperty("following_url")
    private String followingUrl;
    @JsonProperty("gists_url")
    private String gistsUrl;
    @JsonProperty("starred_url")
    private String starredUrl;
    @JsonProperty("subscriptions_url")
    private String subscriptionsUrl;
    @JsonProperty("organizations_url")
    private String organizationsUrl;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("received_events_url")
    private String receivedEventsUrl;
    private String type;
    @JsonProperty("site_admin")
    private boolean siteAdmin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private Object hireable;
    private Object bio;
    @JsonProperty("public_repos")
    private int publicRepos;
    @JsonProperty("public_gists")
    private int publicGists;
    private int followers;
    private int following;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getHireable() {
        return hireable;
    }

    public void setHireable(Object hireable) {
        this.hireable = hireable;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
