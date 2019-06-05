package uk.ac.ebi.ddi.social.elixir.connect;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class ElixirOAuth2Template extends OAuth2Template{

	private static String AUTHORIZE_URL = "https://perun.elixir-czech.cz/oidc/authorize";
	private static String ACCESS_TOKEN_URL = "https://perun.elixir-czech.cz/oidc/token";

	@Override
	public AccessGrant exchangeForAccess(String authorizationCode, String redirectUri, MultiValueMap<String, String> additionalParameters) {
		return super.exchangeForAccess(authorizationCode, redirectUri, additionalParameters);
	}

	/**
	 * @param clientId
	 * @param clientSecret
	 */
	public ElixirOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret,AUTHORIZE_URL, ACCESS_TOKEN_URL);
		setUseParametersForClientAuthentication(true);
	}
	
	@Override
	public String buildAuthorizeUrl(OAuth2Parameters parameters) {
		if(parameters.containsKey("_csrf")){
			parameters.remove("_csrf");
		}
		return super.buildAuthorizeUrl(parameters);
	}

	@Override
	public String buildAuthorizeUrl(GrantType grantType, OAuth2Parameters parameters) {
		if(parameters.containsKey("_csrf")){
			parameters.remove("_csrf");
		}
		return super.buildAuthorizeUrl(grantType, parameters);
	}

	@Override
	public String buildAuthenticateUrl(OAuth2Parameters parameters) {
		if(parameters.containsKey("_csrf")){
			parameters.remove("_csrf");
		}
		return super.buildAuthenticateUrl(parameters);
	}

	@Override
	public String buildAuthenticateUrl(GrantType grantType, OAuth2Parameters parameters) {
		if(parameters.containsKey("_csrf")){
			parameters.remove("_csrf");
		}
		return super.buildAuthenticateUrl(grantType, parameters);
	}

}
