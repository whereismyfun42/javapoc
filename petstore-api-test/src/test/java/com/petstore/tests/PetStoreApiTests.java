package com.petstore.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PetStoreApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @DataProvider(name = "statuses")
    public Object[][] createStatuses() {
        return new Object[][] {
            { "available" },
            { "pending" },
            { "sold" }
        };
    }

    @Test(dataProvider = "statuses")
    public void testFindPetsByStatus(String status) {
        Response response = RestAssured.given()
            .queryParam("status", status)
            .when()
            .get("/pet/findByStatus")
            .then()
            .statusCode(200)
            .extract()
            .response();

        // Check if the response contains pets with the correct status
        response.jsonPath().getList("status").forEach(s -> Assert.assertEquals(s, status, "Status does not match"));

        // Print response for debugging
        System.out.println("Response for status " + status + ": " + response.asString());
    }

    @Test
    public void testInvalidStatus() {
        Response response = RestAssured.given()
            .queryParam("status", "invalidstatus")
            .when()
            .get("/pet/findByStatus")
            .then()
            .statusCode(400)
            .extract()
            .response();

        // Print response for debugging
        System.out.println("Response for invalid status: " + response.asString());
    }
}
