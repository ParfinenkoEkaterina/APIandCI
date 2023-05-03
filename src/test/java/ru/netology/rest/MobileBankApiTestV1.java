package ru.netology.rest;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasSize;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
               .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body("", hasSize(3))
                .body("[1].balance", greaterThenOrEqualTo(0))
                .body("every { it.balance >= 0}", is(true));

    }

    @Test
    void jsonSchemaValidator() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }


}
