package org.company.primerproyecto.features;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Ejercicio {

    private static RequestSpecification request;
    private static Response response;

    @Test
    public void requestGetProjects_checkResponseCode_expect200_and_totalCount10(){
        request = given()
                    .contentType("application/json");

        response = request.when()
                .get("http://CESAR-PC:81/redmine/projects.json");

        response.then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

        JsonPath jsonPath = new JsonPath(response.getBody().asString());

        //Assertions.assertEquals(2, jsonPath.getInt("total_count"));
    }

    @Test
    public void requestGetIssue_checkResponseCode_expect200_and_totalCount2(){
        request = given()
                .contentType("application/json");

        response = request.when()
                .get("http://CESAR-PC:81/redmine/issues.json");

        response.then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

        JsonPath jsonPath = new JsonPath(response.getBody().asString());

        //Assertions.assertEquals(1, jsonPath.getInt("total_count"));
    }

    @Test
    public void requestPostCreateIssueRedmine_checkResponseCode_expect201(){
        request = given()
                .contentType("application/json");

        response = request.when()
                .header("X-Redmine-API-Key","d5995d7344ae8fc95c4985b29a0808b899479d81")
                .body("{\n" +
                        "  \"issue\": {\n" +
                        "    \"project_id\": 2,\n" +
                        "    \"subject\": \"Mi primer Issue desde Rest Assured\",\n" +
                        "    \"description\":\"Mi primer Issue desde Rest Assured\",\n" +
                        "    \"priority_id\": 4,\n" +
                        "    \"tracker_id\":1,\n" +
                        "\t\"status_id\":1\n" +
                        "  }\n" +
                        "}")
                .post("http://CESAR-PC:81/redmine/issues.json");

        response.then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }
}
