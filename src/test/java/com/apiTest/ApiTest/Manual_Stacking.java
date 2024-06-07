package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Manual_Stacking {

	   private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
	    static {
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegistration", "Manual Registration In");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegIn", "Brain_IN");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/1", "Manual Stacking Inprogress");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/2", "Manual Stacking Review");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/7", "Auto Stacking Review");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/6", "MRI Registration Review");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/4", "Rework");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/5", "Reject");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/ManualRegSSQuery/3", "Out");
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
	    }
	}