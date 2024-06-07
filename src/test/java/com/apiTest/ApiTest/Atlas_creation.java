package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Atlas_creation {
	private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
    static {
    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreationIn", "Brain_IN");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_brainWait/1", "Brain_Wait");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_SeriesWait_SS", "series_wait");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_SS/12", "IN_Progress");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_SS/3", "Review");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_SS/5", "Reject");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_SS/4", "Out");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/AtlasCreation_Stats", "Stats");
        
    } 

    @Test
    public void testAPIs() {
        for (String endpoint : ENDPOINT_LABELS.keySet()) {
            String endpointLabel = ENDPOINT_LABELS.get(endpoint);
            Response response = RestAssured.get(endpoint);

            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                System.out.println("API request to " + endpointLabel + " passed. Status code: " + statusCode);
            } else {
                System.out.println("API request to " + endpointLabel + " failed. Status code: " + statusCode);
            }

            Assert.assertEquals(statusCode, 200, "API request to " + endpointLabel + " failed");
        }
    }}














