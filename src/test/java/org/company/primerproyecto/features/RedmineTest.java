package org.company.primerproyecto.features;

import org.company.primerproyecto.config.RedmineConfig;
import org.company.primerproyecto.config.RedmineEndpoints;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RedmineTest extends RedmineConfig {

    @Test
    public void createIssueByJson(){
        String issue_body = "{\n" +
                "    \"issue\": {\n" +
                "    \t\"project_id\": 1,\n" +
                "        \"subject\": \"Mi segundo Issue con Rest-Assured y Endpoints\",\n" +
                "        \"description\": \"MMi segundo Issue con Rest-Assured y Endpoints\",\n" +
                "        \"priority_id\":4,\n" +
                "        \"tracker_id\":1,\n" +
                "        \"status_id\":1\n" +
                "    }\n" +
                "}";

        given()
                .body(issue_body).
        when().
                post(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON).
        then()
                .statusCode(201);
    }

    @Test
    public void createIssueByXML(){
        String issue_body = "<issue>\n" +
                "\t<project_id>1</project_id>\n" +
                "  <subject>Mi primer Issue desde Rest-Assured con XML</subject>\n" +
                "  <description>Mi primer Issue desde Rest-Assured con XML</description>\n" +
                "  <priority_id>4</priority_id>\n" +
                "  <tracker_id>1</tracker_id>\n" +
                "  <status_id>1</status_id>\n" +
                "</issue>";

        given()
                .body(issue_body)
                .header("Content-Type","application/xml")
                .header("Accept","application/xml").
        when().
                post(RedmineEndpoints.ALL_REDMINE_ISSUES_XML).
        then()
                .statusCode(201);
    }

    @Test
    public void updateIssueByJSON(){
        String issueBody = "{\n" +
                "  \"issue\": {\n" +
                "  \t\"status_id\":3,\n" +
                "    \"description\": \"The subject was changed from REST-ASSURED\"\n" +
                "  }\n" +
                "}";

        given()
                .body(issueBody).
        when().
                put("issues/6.json").
        then()
                .statusCode(204);

    }

    @Test
    public void deleteIssue(){
        given().
            when()
                .delete("issues/9.json").
            then()
                .statusCode(204);
    }

    @Test
    public void getSingleIssueJSON(){
        given()
            .pathParam("id",7).
        when()
                .get(RedmineEndpoints.SINGLE_REDMINE_ISSUE_JSON).
        then()
                .statusCode(200);
    }

    @Test
    public void getSingleIssueXML(){
        given()
                .pathParam("id",7).
        when()
                .get(RedmineEndpoints.SINGLE_REDMINE_ISSUE_XML).
        then()
                .statusCode(200);
    }
}
