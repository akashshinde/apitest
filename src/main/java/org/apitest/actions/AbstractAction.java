package org.apitest.actions;

import com.mashape.unirest.http.HttpResponse;

import javax.annotation.Nullable;

/**
 * Action defines particular request
 *
 * Eg. We want make GET request to /v2/channels
 *     Endpoint we need to define that as action
 *
 *
 * Every action should return make HTTPRequest
 * to particular endpoint
 *
 */
public abstract class AbstractAction {

    protected String channelData = "{}";
    protected String url = "http://tvpapi.as.tvinci.com/v3_4/gateways/jsonpostgw.aspx";
    protected String id = "12345";

    /**
     *
     * Implement action which will
     * be performed by particular endpoint
     *
     * @param object
     * @return
     * @throws Exception
     */
    public abstract HttpResponse<String> buildAction(@Nullable Object object) throws Exception;

    /**
     * Implement validation logic required to test
     * above action mentioned in
     *
     * <code>buildAction(obj)<code/>
     *
     * @param response
     * @throws Exception
     */
    public abstract void responseMiddleware(HttpResponse<String> response) throws Exception;
}
