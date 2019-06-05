package uk.ac.ebi.ddi.social.elixir.connect;

import uk.ac.ebi.ddi.social.elixir.api.Elixir;
import uk.ac.ebi.ddi.social.elixir.api.impl.ElixirTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class ElixirServiceProvider extends AbstractOAuth2ServiceProvider<Elixir> {

	public ElixirServiceProvider(String clientId, String clientSecret) {
		super(new ElixirOAuth2Template(clientId, clientSecret));
	}

	@Override
	public Elixir getApi(String accessToken) {
		return new ElixirTemplate(accessToken);
	}
}
