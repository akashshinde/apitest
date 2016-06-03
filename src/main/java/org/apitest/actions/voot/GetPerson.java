package org.apitest.actions.voot;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.actions.AbstractAction;
import org.apitest.request.Request;
import org.apitest.response_middleware.AbstractResponseMiddleware;

import javax.annotation.Nullable;
import java.util.HashMap;

/**
 * Created by akash on 03/06/16.
 */

@org.apitest.core.Action(name = "GET_PERSON")
public class GetPerson extends AbstractAction{
    public GetPerson() throws Exception {
    }

    public AbstractResponseMiddleware addCustomMiddleware() {
        return null;
    }

    /**
     * Implement action which will
     * be performed by particular endpoint
     *
     * @param object
     * @return
     * @throws Exception
     */
    public HttpResponse<String> buildAction(@Nullable Object object) throws Exception {
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("m","SearchAssets");
        return Request.makeRequest(Request.METHOD.GET,url,null,map);
    }

    /**
     * Implement validation logic required to test
     * above action mentioned in
     * <p>
     * <code>buildAction(obj)<code/>
     *
     * @param response
     * @throws Exception
     */
    public void responseMiddleware(HttpResponse<String> response) throws Exception {
        if (response.getStatus() == 200){
            return;
        }else{
            throw new AssertionError("error");
        }
    }
}
