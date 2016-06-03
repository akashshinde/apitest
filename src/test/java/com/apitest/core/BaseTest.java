package com.apitest.core;

import com.mashape.unirest.http.HttpResponse;
import org.apitest.actions.AbstractAction;
import org.apitest.context.TestContext;
import org.apitest.response_middleware.AbstractResponseMiddleware;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Created by akash on 02/06/16.
 */
public class BaseTest {

    /**
     * dispatch() method call will
     * dispatch specified action
     *
     * @param action action
     * @param data   data which will be needed by api endpoint
     */
    protected void dispatch(String action, Object data) throws Exception{
        try {
            TestContext context = TestContext.getSharedInstance();
            context.loadActions();
            HashMap<String, AbstractAction> map = TestContext.getSharedInstance().getActions();
            for (int i = 0; i < map.size(); i++) {
                for (Map.Entry<String, AbstractAction> entry : map.entrySet()) {
                    if (entry.getKey().equals(action)) {
                        AbstractAction a = entry.getValue();
                        a.getResponseMiddlewares().addAll(context.getResponseMiddleware());
                        a.getResponseMiddlewares().add(a.addCustomMiddleware());
                        HttpResponse<String> response = entry.getValue().buildAction(data);
                        executeMiddleware(a.getResponseMiddlewares(),response);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            throw new AssertionError("Failed to validate");
        }
    }

    private void executeMiddleware(LinkedList<AbstractResponseMiddleware> handlers, HttpResponse<String> response) throws Exception {
        for (AbstractResponseMiddleware responseMiddleware : handlers){
            if (responseMiddleware != null) {
                responseMiddleware.executeResponseMiddleware(response);
                System.out.println("Executing middleware  :  " + responseMiddleware.getClass().toString());
            }
        }
    }
}
