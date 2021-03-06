package com.apitest.voot;

import com.apitest.core.BaseTest;
import org.apitest.context.TestContext;
import org.apitest.response_middleware.common.Logger;
import org.apitest.response_middleware.common.ResponseOK;
import org.testng.annotations.Test;

/**
 * Created by akash on 03/06/16.
 */
public class TestPerson extends BaseTest{

    public TestPerson() throws Exception {
        TestContext testContext = TestContext.getSharedInstance();
        testContext.loadActions();
        testContext.addResponseMiddleware(new Logger());
        testContext.addResponseMiddleware(new ResponseOK());
    }

    @Test
    public void testGetPerson() throws Exception {
        dispatch("GET_PERSON",null);
    }
}
