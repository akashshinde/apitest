package org.apitest.core;

import org.apitest.actions.AbstractAction;
import org.apitest.context.TestContext;
import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by akash on 02/06/16.
 */
public class CollectActions {

    public static void main(String[] args) throws Exception {
        Reflections reflections = new Reflections("org.apitest.actions");
        Set<Class<?>> allActions = reflections.getTypesAnnotatedWith(Action.class);

        for (Class<?> thisClass: allActions){
            TestContext.getSharedInstance().addAction((AbstractAction)thisClass.newInstance());
        }
    }
}