package org.apitest.context;

import org.apitest.actions.AbstractAction;
import org.apitest.core.Action;
import org.apitest.response_middleware.AbstractResponseMiddleware;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by akash on 02/06/16.
 */
public class TestContext {
    private static TestContext testContext = null;
    private boolean loaded = false;

    private HashMap<String,AbstractAction> actions = new HashMap<String, AbstractAction>();
    private ArrayList<AbstractResponseMiddleware> responseMiddleware = new ArrayList<AbstractResponseMiddleware>();

    public HashMap<String, AbstractAction> getActions() {
        return actions;
    }

    public synchronized static TestContext getSharedInstance() throws Exception {
        if (testContext == null) {
            testContext = new TestContext();
        }
        return testContext;
    }

    public void loadActions() throws Exception{
        if (!loaded) {
            Reflections reflections = new Reflections("org.apitest.actions");
            Set<Class<?>> allActions = reflections.getTypesAnnotatedWith(Action.class);
            for (Class<?> thisClass : allActions) {
                addAction((AbstractAction) thisClass.newInstance());
            }
            loaded = true;
        }
    }

    public void addResponseMiddleware(AbstractResponseMiddleware middleware){
        responseMiddleware.add(middleware);
    }

    public void addAction(AbstractAction action){
        if (action.getClass().isAnnotationPresent(Action.class)){
            Action ac = action.getClass().getAnnotation(Action.class);
            actions.put(ac.name(),action);
        }
    }

    public ArrayList<AbstractResponseMiddleware> getResponseMiddleware() {
        return responseMiddleware;
    }

    public void setResponseMiddleware(ArrayList<AbstractResponseMiddleware> responseMiddleware) {
        this.responseMiddleware = responseMiddleware;
    }
}
