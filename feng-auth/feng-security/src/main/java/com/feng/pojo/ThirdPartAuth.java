package com.feng.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/1/23.
 */

@Data
@NoArgsConstructor
@Table(name = "t_third_part_auth")
@Entity
public class ThirdPartAuth extends BaseEntity {
    @Column(name = "user_id",nullable = false)
    private String userId;
    @Column(name = "provider_id",nullable = false)
    private String providerId;
    @Column(name = "provider_user_id",nullable = false)
    private String providerUserId;
    @Column(name = "rank",nullable = false,columnDefinition = "int default 0")
    private Integer rank;
    @Column(name = "display_name", nullable = false)
    private String displayName;
    @Column(name = "profile_url")
    private String profileUrl;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "access_token",nullable = false)
    private String accessToken;
    @Column(name = "secret",nullable = false)
    private String secret;
    @Column(name = "refresh_token",nullable = false)
    private String refreshToken;
    @Column(name = "expire_time",nullable = false,columnDefinition = "bigint default 0" )
    private Long expireTime;
    @Column(name = "open_id")
    private String openId;


}
