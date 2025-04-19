package jira.services;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import jira.models.Fields;
import jira.models.Issuetype;
import jira.models.Project;
import jira.models.Root;

public class Issues {
	
	public Issues() {
		baseURI = "https://karthikeselene.atlassian.net";
		basePath = "/rest/api/3";				        
	}
	
	public void createBug(String summary) {
		
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
		
		given() 
		.auth()
		.preemptive()
		.basic("", "")
		.contentType(ContentType.JSON)
		       .log().all()
		       .when()
		       .body(root)
		       .post("/issue")
		       .then()
		       .log().all();
	}

}