package org.apitest.response_middleware;

import com.mashape.unirest.http.HttpResponse;

/**
 * Created by akash on 02/06/16.
 */
public abstract class AbstractResponseMiddleware {
    public static final int STATUS_OK = 200;
    public abstract void buildResponseMiddleware(HttpResponse<String> response) throws Exception;
}
