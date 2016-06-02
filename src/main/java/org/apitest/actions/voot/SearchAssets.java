package org.apitest.actions.voot;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.actions.AbstractAction;
import org.apitest.core.Action;
import org.apitest.request.Request;

import java.util.HashMap;

/**
 * Created by akash on 02/06/16.
 */
@Action(name = "SEARCH_ASSETS")
public class SearchAssets extends AbstractAction{

    public HttpResponse<String> buildAction(Object object) throws Exception {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("m","SearchAssets");
        return Request.makeRequest(Request.METHOD.GET,url,null,map);
    }

    public void responseMiddleware(HttpResponse<String> response) throws Exception {
        if (response.getStatus() == 200){
            System.out.println("request has response 200");
        }else{
            System.out.println(response.getBody());
        }
    }
}
