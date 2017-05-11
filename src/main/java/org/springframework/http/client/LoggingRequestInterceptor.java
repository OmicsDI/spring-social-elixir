package org.springframework.http.client;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.http.client.BufferingClientHttpResponseWrapper;
import org.apache.commons.io.IOUtils;

/**
 * Created by user on 5/9/2017.
 */
    public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(final HttpRequest request, final byte[] body,
                                            final ClientHttpRequestExecution execution) throws IOException {
            ClientHttpResponse response = execution.execute(request, body);

            response = log(request, body, response);

            return response;
        }

        private ClientHttpResponse log(final HttpRequest request, final byte[] body, final ClientHttpResponse response) {
            final ClientHttpResponse responseCopy = new BufferingClientHttpResponseWrapper(response);
            System.out.print("\nMethod: " + request.getMethod().toString());
            System.out.print("\nURI: " + request.getURI().toString());
            for(String key : request.getHeaders().keySet()){
                System.out.print("\nHeader: " + key + "=");
                for(String val :request.getHeaders().get(key)){
                    System.out.print(" " + val);
                }
            }
            System.out.print("\nHeaders: " + request.getHeaders().toString());
            System.out.print("\nRequest Body: " + new String(body));
            try {
                System.out.print("\nResponse body: " + IOUtils.toString(responseCopy.getBody()));
            }
            catch(IOException ex){
                System.out.print("\nIOException in body: " + ex.getMessage());
            }
            return responseCopy;
        }

    }
