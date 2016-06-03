package com.apitest.voot;

import com.apitest.core.BaseTest;
import org.apitest.context.TestContext;
import org.apitest.response_middleware.common.Logger;
import org.apitest.response_middleware.common.ResponseOK;
import org.testng.annotations.Test;

/**
 * Created by akash on 02/06/16.
 */
public class TestVoot extends BaseTest{

    public TestVoot() throws Exception {
        TestContext testContext = TestContext.getSharedInstance();
        testContext.loadActions();
        testContext.addResponseMiddleware(new Logger());
        testContext.addResponseMiddleware(new ResponseOK());
    }

    @Test
    public void createTest() throws Exception {
        dispatch("SEARCH_ASSETS",null);
    }

    @Test
    public void searchAsset() throws Exception {
        dispatch("SEARCH_ASSETS",null);
    }
}