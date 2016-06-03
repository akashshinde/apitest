package com.apitest.channel;

import com.apitest.core.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by akash on 02/06/16.
 */
public class TestChannel extends BaseTest{

    @Test
    public void createTest() throws Exception {
        dispatch("CREATE_CHANNEL",null);
    }

}