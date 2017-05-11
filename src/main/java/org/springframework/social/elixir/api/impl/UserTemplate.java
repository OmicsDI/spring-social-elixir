package org.springframework.social.elixir.api.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.LoggingRequestInterceptor;
import org.springframework.social.elixir.api.ElixirProfile;
import org.springframework.social.elixir.api.UserOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class UserTemplate extends AbstractElixirOperations implements UserOperations{
	private final RestTemplate restTemplate;
	public UserTemplate(ElixirTemplate elixirTemplate, RestTemplate restTemplate, boolean authorized) {
		super(authorized);
		this.restTemplate = restTemplate;
	}

	@Override
	public ElixirProfile getUserProfile() {
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.set

		HttpEntity<?>httpEntity=new HttpEntity<>(headers);

		//ElixirProfile user=restTemplate.exchange(buildUri("oidcManager/userinfo"), HttpMethod.GET, httpEntity, ElixirProfile.class).getBody();

		//requireUserAuthorization();

		restTemplate.getInterceptors().add(new LoggingRequestInterceptor());

		ElixirProfile user = restTemplate.getForObject(buildUri("oidcManager/userinfo"), ElixirProfile.class);
		
		return user;
	}

}
