package org.company.primerproyecto.config;

public interface RedmineEndpoints {

    String MY_LOGIN_ACCOUNT_JSON = "my/account.json";

    String ALL_REDMINE_ISSUES_JSON = "issues.json";
    String ALL_REDMINE_ISSUES_XML = "issues.xml";

    String SINGLE_REDMINE_ISSUE_JSON = "issues/{id}.json";
    String SINGLE_REDMINE_ISSUE_XML = "issues/{id}.xml";

    String SINGLE_REDMINE_PROJECT_JSON = "projects/{id}.json";
    String SINGLE_REDMINE_PROJECT_XML = "projects/{id}.xml";

    String ALL_REDMINE_PROJECT_JSON = "projects.json";
}
