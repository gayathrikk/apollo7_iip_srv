package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Dashboard_Imaging {
	
		
		private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
	    static {
	    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardImageQC", "Imaging_IN");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/1", "Imaging_ToDo");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/234", "Imaging_Scanning");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/6", "Image_QC");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/11", "Bio_QC");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/7", "Publishing");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/5", "Batch_Failed");
	        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryImageQCBatchs/8", "Image_Out");
	        
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

	
	
	