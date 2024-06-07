package com.test.Dashboard_apis;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dashboard_manipulation_API {
	
	 
	private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
    static {
    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardSubject", "Manipulation_In");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/1", "Manipulation_Waiting");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/2", "Manipulation_InProgress");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/5", "Rejected");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/3", "Subject_Ready");

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