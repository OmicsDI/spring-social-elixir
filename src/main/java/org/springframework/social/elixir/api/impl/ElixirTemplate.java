package org.springframework.social.elixir.api.impl;

import org.springframework.social.elixir.api.Elixir;
import org.springframework.social.elixir.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class ElixirTemplate extends AbstractOAuth2ApiBinding implements Elixir{

	private UserOperations userOperations;
	
	public ElixirTemplate() {
		initialize();
	}

	public ElixirTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}
	
	
	private void initialize() {
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();

	}

	private void initSubApis() {
		userOperations = new UserTemplate(this, getRestTemplate(), isAuthorized());
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}
}
