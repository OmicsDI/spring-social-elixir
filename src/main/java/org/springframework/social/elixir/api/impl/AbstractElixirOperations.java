package org.springframework.social.elixir.api.impl;

import org.springframework.social.MissingAuthorizationException;

/**
 * Created by user on 5/9/2017.
 */

class AbstractElixirOperations {
	private final boolean isAuthorized;
	
	public AbstractElixirOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("elixir");
		}
	}
	
	// Using String here instead of URI so I can include braces in the path. See, e.g., RepoTemplate. [WLW]
	protected String buildUri(String path) {
//		return URIBuilder.fromUri(API_URL_BASE + path).build();
		return API_URL_BASE + path;
	}
	
	private static final String API_URL_BASE = "https://perun.elixir-czech.cz/oauth/rpc/json/";
}
