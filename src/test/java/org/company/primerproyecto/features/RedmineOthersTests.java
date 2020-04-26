package org.company.primerproyecto.features;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.company.primerproyecto.config.RedmineConfig;
import org.company.primerproyecto.config.RedmineEndpoints;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

public class RedmineOthersTests extends RedmineConfig {

    @Test
    public void LoginPage(){
        given().

        when()
                .get(RedmineEndpoints.MY_LOGIN_ACCOUNT_JSON).
        then()
                .statusCode(200);
    }

    @Test
    public void getIssueStartDate(){
        given()
                .pathParam("id",7).
        when()
                .get(RedmineEndpoints.SINGLE_REDMINE_ISSUE_XML).
        then()
                .body("issue.start_date",equalTo("2020-04-25"))
                .statusCode(200);
    }

    @Test
    public void getFirstIssueSubject(){
        given().
        when()
                .get(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON).
        then()
                .body("issues[0].subject",equalTo("Mi primer Issue desde Postman"))
                .statusCode(200);
    }

    @Test
    public void getAllIssueData(){
        String responseBody = get("issues/7.json").asString();
        System.out.println(responseBody);
    }

    @Test
    public void getAllIssueDataCheck(){
        Response response = given().
                            when()
                                .get("issues/7.json").
                            then()
                                .statusCode(200)
                                .extract().response();
        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
    }

    @Test
    public void extractHeaders(){
        Response response =
                given().
                        when()
                        .get("issues/13.json").
                        then()
                        .statusCode(200)
                        .extract().response();

        Headers headers = response.getHeaders();

        String contentType = response.getHeader("Content-Type");

        System.out.println(contentType);
    }

    @Test
    public void extractFirstIssueSubject(){

        String firstIssueSubject = get(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON).jsonPath().getString("issues[0].subject");
        System.out.println(firstIssueSubject);
    }


    @Test
    public void extractAllIssueSubjects(){

        Response response =
                given().
                        when()
                        .get(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON).
                        then()
                        .extract().response();

        List<String> subjects = response.path("issues.subject");

        for(String subject : subjects){
            System.out.println(subject);
        }
    }
}
