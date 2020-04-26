package org.company.primerproyecto.features;

import org.company.primerproyecto.config.RedmineConfig;
import org.company.primerproyecto.config.RedmineEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.get;

public class MyFirstTest extends RedmineConfig {

    @Test
    public void myFirstTestwithEndpoint(){
        get(RedmineEndpoints.ALL_REDMINE_ISSUES_JSON)
                .then().log().all();
    }
}
