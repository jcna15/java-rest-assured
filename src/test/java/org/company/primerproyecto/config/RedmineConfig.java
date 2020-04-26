package org.company.primerproyecto.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
//import org.junit.jupiter.api.BeforeAll;

public class RedmineConfig {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://CESAR-PC")
                .setBasePath("/redmine") //redmine
                .setPort(81)
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .addHeader("X-Redmine-API-Key","d5995d7344ae8fc95c4985b29a0808b899479d81")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        responseSpecification = new ResponseSpecBuilder()
                //.expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }

}
