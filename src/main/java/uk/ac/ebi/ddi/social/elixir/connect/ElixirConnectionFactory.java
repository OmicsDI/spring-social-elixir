package uk.ac.ebi.ddi.social.elixir.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import uk.ac.ebi.ddi.social.elixir.api.Elixir;

public class ElixirConnectionFactory extends OAuth2ConnectionFactory<Elixir> {

	public ElixirConnectionFactory(String clientId, String clientSecret) {
		super("elixir", new ElixirServiceProvider(clientId, clientSecret), new ElixirAdapter());
	}
}
