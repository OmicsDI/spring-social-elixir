package uk.ac.ebi.ddi.social.elixir.api.impl;

import uk.ac.ebi.ddi.social.elixir.api.Elixir;
import uk.ac.ebi.ddi.social.elixir.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.support.ClientHttpRequestFactorySelector;

public class ElixirTemplate extends AbstractOAuth2ApiBinding implements Elixir {

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
