package com.apiTest.ApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ap7v1_api {

	 @Test(priority=1)
    public void iipsrv()
    
       {
           Response response1 = RestAssured
                   .given()
                   .auth()
                   .basic("admin", "admin")
                   .when()
                   .get("https://ap7v1.humanbrain.in/iipsrv/fcgi-bin/iipsrv.fcgi?FIF=/apollo6/storageIIT/humanbrain/analytics/207/NISL/B_207_FB47-SL_150-ST_NISL-SE_448_compressed.jp2&WID=1024&GAM=1.4&MINMAX=1:0,255&MINMAX=2:0,255&MINMAX=3:0,255&JTL=0,0");

           int statusCode1 = response1.getStatusCode();
           if (statusCode1 == 200) {
           	System.out.println("_________________________******_______________________");
               System.out.println("API request to the apollo7v1 iipsrv passed. Status code: " + statusCode1);
               byte[] responseBody = response1.getBody().asByteArray(); 
               System.out.println("_________________________******_______________________");
               System.out.println("Response body length: " + responseBody.length); 
               System.out.println("_________________________******_______________________");
           } else {
           	System.out.println("_________________________******_______________________");
               System.out.println("API request to the apollo6 iipsrv failed. Status code: " + statusCode1);
           }
           Assert.assertEquals(statusCode1, 200, "API request to the apollo6 iipsrv failed");
           
       }
	}


