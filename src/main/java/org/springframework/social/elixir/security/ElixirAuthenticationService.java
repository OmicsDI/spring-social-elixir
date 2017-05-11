package org.springframework.social.elixir.security;

import org.springframework.social.elixir.api.Elixir;
import org.springframework.social.elixir.connect.ElixirConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class ElixirAuthenticationService extends OAuth2AuthenticationService<Elixir>{
	
	public ElixirAuthenticationService(String clientId, String clientSecret){
		super(new ElixirConnectionFactory(clientId, clientSecret));
	}

}
