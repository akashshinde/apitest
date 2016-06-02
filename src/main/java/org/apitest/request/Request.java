package org.apitest.request;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;

import java.util.HashMap;

/**
 * Created by akash on 02/06/16.
 */
public class Request {

    /**
     * Makes request to provided API
     * endpoint
     *
     * @param method http method
     * @param url endpoint
     * @param body body data if any
     * @param params url parameters
     * @return response
     */
    public static HttpResponse<String> makeRequest(METHOD method, String url, String body, HashMap<String,Object> params) throws Exception{
        HttpRequest request = null;
        switch (method){
            case GET:
                request = Unirest.get(url).queryString(params);
                break;
            case POST:
                request = Unirest.post(url);
                break;
            case DELETE:
                request = Unirest.delete(url);
                break;
            case PATCH:
                request = Unirest.delete(url).queryString(params);
                break;
            case PUT:
                request = Unirest.put(url).queryString(params);
                break;
            default:
                break;
        }
        // Call request middleware
        return request.asString();
    }

    public enum METHOD {
        GET,
        POST,
        PATCH,
        DELETE,
        PUT
    }
}
