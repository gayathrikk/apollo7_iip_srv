package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MRI_Skull_Stripping {
	
	
	 
		
		private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
	    static {
	    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardMRI", "MRI_IN");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/1", "MRI_Upload");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/2", "MRI_Automatic");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/3", "MRI_ManualCorrect");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/4", "MRI_QC");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/5", "MRI_Redo");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/querySkullStrip/6", "MRI_Out");

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
	        
	        }}}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	