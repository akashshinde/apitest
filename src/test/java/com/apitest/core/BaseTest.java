package com.apitest.core;

import org.apitest.actions.AbstractAction;
import org.apitest.context.TestContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akash on 02/06/16.
 */
public class BaseTest {

    /**
     * dispatch() method call will dispatch
     * specified action
     *
     * @param action action
     * @param data   data which will be needed by api endpoint
     */
    protected void dispatch(String action, Object data) {
        try {
            TestContext.getSharedInstance().loadActions();
            HashMap<String, AbstractAction> map = TestContext.getSharedInstance().getActions();
            for (int i = 0; i < map.size(); i++) {
                for (Map.Entry<String, AbstractAction> entry : map.entrySet()) {

                    if (entry.getKey().equals(action)) {
                        entry.getValue().responseMiddleware(entry.getValue().buildAction(data));
                    }
                }
            }
        } catch (Exception e) {
            throw new AssertionError("Failed to validate");
        }
    }
}
