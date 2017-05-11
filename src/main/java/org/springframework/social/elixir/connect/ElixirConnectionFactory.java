package org.springframework.social.elixir.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.elixir.api.Elixir;

public class ElixirConnectionFactory extends OAuth2ConnectionFactory<Elixir> {

	public ElixirConnectionFactory(String clientId, String clientSecret) {
		super("elixir", new ElixirServiceProvider(clientId, clientSecret), new ElixirAdapter());
	}
}
