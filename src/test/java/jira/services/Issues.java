package jira.services;

import static io.restassured.RestAssured.*;
import static utils.PropertiesHandlers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jira.models.Fields;
import jira.models.Issuetype;
import jira.models.Project;
import jira.models.Root;

public class Issues {	
	
	public Issues() {
		baseURI = config("jira.base.uri");
		basePath = config("jira.base.path");				        
	}
	
	public Response createBug(String summary) {
		
		Root root = new Root();
		Fields fields = new Fields();
		Issuetype issuetype = new Issuetype();
		Project project = new Project();
		
		project.setKey("SB");
		issuetype.setName("Bug");
		
		fields.setProject(project);
		fields.setIssuetype(issuetype);
		fields.setSummary(summary);
		
		root.setFields(fields);
		
		return given()
				.auth()
				.preemptive()
				.basic(config("jira.username"), secret("jira.api.token"))
          		.contentType(ContentType.JSON)
		        .log().all()
		        .when()
		        .body(root)
		        .post("/issue");
	}

}