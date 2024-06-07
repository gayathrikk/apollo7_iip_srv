package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Cryo_Blocking {
	
	  private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
	    static {
	    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardCryoBlock", "CryoBlock");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardCryoBlock", "CryoBlock_Add");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryCryoBlock/1", "CryoBloack_Waiting");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryCryoBlock/2", "Cryo_Blocking_Frozen_InProgress");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryCryoBlock/3", "Cryo_Blocking_Out");
	        
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
	
	
	