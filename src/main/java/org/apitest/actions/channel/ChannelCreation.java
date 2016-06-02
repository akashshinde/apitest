package org.apitest.actions.channel;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.actions.AbstractAction;
import org.apitest.core.Action;
import org.apitest.request.Request;

/**
 * Created by akash on 02/06/16.
 */

@Action(name = "CREATE_CHANNEL")
public class ChannelCreation extends AbstractAction{

    public HttpResponse<String> buildAction(Object object) throws Exception {
        return Request.makeRequest(Request.METHOD.GET,url,null,null);
    }

    public void responseMiddleware(HttpResponse<String> response) throws Exception {
//        convertToJSON = response.getBody();
//        convertToJSON.has("id");
    }

}
