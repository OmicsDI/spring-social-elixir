package uk.ac.ebi.ddi.social.elixir.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import uk.ac.ebi.ddi.social.elixir.api.Elixir;
import uk.ac.ebi.ddi.social.elixir.api.ElixirProfile;

public class ElixirAdapter implements ApiAdapter<Elixir>{

	@Override
	public boolean test(Elixir api) {
		try {
			api.userOperations().getUserProfile();
			return true;
		} catch(ApiException e) {
			return false;
		}
	}

	@Override
	public void setConnectionValues(Elixir api, ConnectionValues values) {
		ElixirProfile profile = api.userOperations().getUserProfile();
		values.setProviderUserId(profile.getSub());
		values.setDisplayName(profile.getName());
	}

	@Override
	public UserProfile fetchUserProfile(Elixir api) {
		ElixirProfile profile=api.userOperations().getUserProfile();
		
		return new UserProfileBuilder()
				.setFirstName(profile.getFirstName())
				.setLastName(profile.getLastName())
				.setEmail(profile.getEmail())
				.setId(profile.getSub())
				.build();
	}

	@Override
	public void updateStatus(Elixir api, String message) {
		// TODO Auto-generated method stub
	}

}
