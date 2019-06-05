package uk.ac.ebi.ddi.social.elixir.security;

import uk.ac.ebi.ddi.social.elixir.api.Elixir;
import uk.ac.ebi.ddi.social.elixir.connect.ElixirConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class ElixirAuthenticationService extends OAuth2AuthenticationService<Elixir>{
	
	public ElixirAuthenticationService(String clientId, String clientSecret){
		super(new ElixirConnectionFactory(clientId, clientSecret));
	}

}
