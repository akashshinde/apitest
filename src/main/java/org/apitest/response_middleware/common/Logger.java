package org.apitest.response_middleware.common;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.response_middleware.AbstractResponseMiddleware;

/**
 * Created by akash on 02/06/16.
 */
public class Logger extends AbstractResponseMiddleware{

    public void executeResponseMiddleware(HttpResponse<String> response) throws Exception {
        System.out.println("Response body : "+ response.getBody() + "\n");
        System.out.println("Response status : "+ response.getStatus());
    }
}
