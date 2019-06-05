package uk.ac.ebi.ddi.social.elixir.api;

import org.springframework.social.ApiBinding;

public interface Elixir extends ApiBinding{

	UserOperations userOperations();
}
