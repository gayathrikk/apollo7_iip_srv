package com.apiTest.ApiTest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Organ_extraction {
	
	
	private static final Map<String, String> ENDPOINT_LABELS = new LinkedHashMap<>();
    static {
    	 ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/dashboardOrganExtraction", "Organ_extraction");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/3", "Organ_extraction_Subject_In");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/1", "MRI ToDo");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/2", "MRI Done");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/3", "Perfusion Done");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/5", "Rejected");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryOrganStatus/4", "Organ_Out");
        ENDPOINT_LABELS.put("https://apollo2.humanbrain.in/dashboard/queryManipulation/4", "Subject_Completed");


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



