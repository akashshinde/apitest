package org.apitest.response_middleware;

import com.mashape.unirest.http.HttpResponse;

/**
 * Created by akash on 02/06/16.
 */
public class ResponseOKMiddleware extends AbstractResponseMiddleware{

    public void executeResponseMiddleware(HttpResponse<String> response) throws Exception {
        if (response.getStatus() == STATUS_OK){
            System.out.println("Response is : "+200);
        }else{
            throw new AssertionError("Response not matching"+response.toString());
        }
    }
}
