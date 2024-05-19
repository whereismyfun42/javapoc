package com.petstore.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestConfig {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
