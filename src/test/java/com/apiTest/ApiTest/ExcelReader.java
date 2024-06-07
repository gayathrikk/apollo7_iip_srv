package com.apiTest.ApiTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExcelReader {

    @Test
    public void testAPIs() {
        // Load data from Excel file
    	
        Map<String, String> ENDPOINT_LABELS = readEndpointsFromExcel("src/test/resource/endpoints.xlsx");
        
        if (ENDPOINT_LABELS == null || ENDPOINT_LABELS.isEmpty()) {
            System.out.println("No data found in the Excel file.");
            return;
        }
        
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
    
    // Method to read endpoints from Excel file
    private Map<String, String> readEndpointsFromExcel(String filePath) {
        Map<String, String> endpointLabels = new LinkedHashMap<>();
        
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            
            for (Row row : sheet) {
                Cell endpointCell = row.getCell(0); // Assuming endpoint URLs are in the first column
                Cell labelCell = row.getCell(1); // Assuming endpoint labels are in the second column
                
                if (endpointCell != null && labelCell != null) {
                    String endpoint = endpointCell.getStringCellValue();
                    String label = labelCell.getStringCellValue();
                    endpointLabels.put(endpoint, label);
                }
            }
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
        
        return endpointLabels;
    }
}