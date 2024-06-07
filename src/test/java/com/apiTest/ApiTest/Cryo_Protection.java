package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Cryo_Protection {
	
	private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
    static {
    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardCryoProtection", "Cryo Protection");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/4", "Cryo_Protection_In");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/6", "Cryo_Protection_Waiting");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/7", "Cryo_Protection_Stage-I");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/8", "Cryo_protection_Stage_II");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/9", "Cryo_protection_Stage_III");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/10", "Cryo_protection_Out");
        
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
