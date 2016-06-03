package org.apitest.actions.channel;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.actions.AbstractAction;
import org.apitest.core.Action;
import org.apitest.request.Request;
import org.apitest.response_middleware.AbstractResponseMiddleware;

/**
 * Created by akash on 02/06/16.
 */

@Action(name="GET_CHANNEL")
public class ChannelGet extends AbstractAction{
    public ChannelGet() throws Exception {
    }

    public AbstractResponseMiddleware addCustomMiddleware() {
        return null;
    }

    public HttpResponse<String> buildAction(Object object) throws Exception {
        int id = (Integer) object;
        return Request.makeRequest(Request.METHOD.GET,url+"/"+id,null,null);
    }

    public void responseMiddleware(HttpResponse<String> response) throws Exception {

    }
}