package org.apitest.response_middleware.common;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.response_middleware.AbstractResponseMiddleware;

/**
 * Created by akash on 03/06/16.
 */
public class ResponseOK extends AbstractResponseMiddleware{
    public void executeResponseMiddleware(HttpResponse<String> response) throws Exception {
        if (response.getStatus() == STATUS_OK) {
            System.out.println("got proper response : "+ response.getStatusText());
        }else{
            throw new AssertionError("response false : "+ response.getStatusText());
        }
    }
}
