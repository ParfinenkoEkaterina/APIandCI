package ru.netology.rest;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
        ;
    }
}
