package uk.ac.ebi.ddi.social.elixir.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElixirProfile {

	/*
	"sub": "5d16d564135a4363ada44b809169275ead3244bf@elixir-europe.org",
			"name": "Ondrej Velisek",
			"given_name": "Ondrej",
			"family_name": "Velisek",
			"email": "ondrejvelisek@gmail.com"
	*/

	private String sub;

	private String email;

	private String name;

	private String given_name;

	private String family_name;

	public void setSub(String sub) {
		this.sub = sub;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public ElixirProfile(){
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSub() {
		return sub;
	}

	public String getFirstName() { return given_name;}

	public String getLastName() {
		return family_name;
	}
}
