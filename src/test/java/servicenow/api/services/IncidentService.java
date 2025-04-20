package servicenow.api.services;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentService {
	
	Response response;

	public void getIncidents() {		
		response = given().log().headers().when().get("/incident");		
	}

	public void getIncident(String sysId) {
		response = given().log().headers().when().get("/incident/"+sysId);		
	}

	public void getIncidetsByCategory(String category) {
		response = given()
		.queryParam("sysparm_query", "category="+category)
		.log().headers()
		.when().get("/incident");
	}

	public void createIncident(Map<String, String> headers, Object payload) {
		response = given()				
		.headers(headers)
		.log().all()
		.when()
		.body(payload)
		.post("/incident");
	}

	public void createIncident(Map<String, String> headers) {
		response = given()
		.headers(headers)
		.log().all()
		.when()		
		.post("/incident");
	}

	public void validateResponse(int statusCode, String statusLine) {
		response.then()
		 .assertThat()
		 .statusCode(statusCode)
		 .statusLine(Matchers.containsString(statusLine));		 
	}
	
	public void validateResponseContentType(ContentType contentType) {
		response.then().assertThat()
		        .contentType(contentType);
	}
	
	public String responseAsString() {
		return response.asPrettyString();
	}

}