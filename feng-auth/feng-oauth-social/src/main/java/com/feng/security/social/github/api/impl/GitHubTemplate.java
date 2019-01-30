package com.feng.security.social.github.api.impl;

import com.feng.security.social.github.api.GitHub;
import com.feng.security.social.github.api.GitHubUser;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;

import java.nio.charset.Charset;
import java.util.List;

public class GitHubTemplate extends AbstractOAuth2ApiBinding implements GitHub {

	/**
	 * No-arg constructor to support cases in which you want to call the GitHub
	 * API without requiring authorization. This is useful for public operations,
	 * such as getting the list of watchers for a public repository.
	 */
	public GitHubTemplate() {
		super();
	}
	
	/**
	 * Constructs a GitHubTemplate with the minimal amount of information
	 * required to sign requests with an OAuth <code>Authorization</code>
	 * header.
	 * 
	 * @param accessToken
	 *            An access token granted to the application after OAuth
	 *            authentication.
	 */
	public GitHubTemplate(String accessToken) {
		super(accessToken);
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER;
	}

	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
		messageConverters.remove(0);
		messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		return messageConverters;
	}

	@Override
	public GitHubUser getUserInfo(String openId) {
//		getRestTemplate()
		return null;
	}
}