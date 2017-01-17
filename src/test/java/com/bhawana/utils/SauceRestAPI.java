package com.bhawana.utils;

import com.saucelabs.saucerest.SauceREST;

import java.util.HashMap;
import java.util.Map;


public class SauceRestAPI {
    public static SauceREST sauceRESTClient;

    public static void updateResults(String username, String accessKey, boolean scenarioResult, String sessionId) {
        sauceRESTClient = new SauceREST(username, accessKey);
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed",scenarioResult);
        sauceRESTClient.updateJobInfo(sessionId,updates);
    }
}


