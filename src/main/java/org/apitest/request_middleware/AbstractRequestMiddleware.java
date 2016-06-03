package org.apitest.request_middleware;

import com.mashape.unirest.request.HttpRequest;

/**
 * Created by akash on 02/06/16.
 */
public abstract class AbstractRequestMiddleware {
    public abstract HttpRequest modifyRequest(HttpRequest request);
}
