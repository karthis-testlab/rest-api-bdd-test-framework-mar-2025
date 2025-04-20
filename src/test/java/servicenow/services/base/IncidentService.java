package servicenow.services.base;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import base.RestAssuredBaseImpl;
import design.ResponseAPI;
import io.restassured.specification.RequestSpecification;

public class IncidentService {
	
	ResponseAPI response;
	RestAssuredBaseImpl base = new RestAssuredBaseImpl();	
	
	public void getIncidents(RequestSpecification requestSpecification) {
		response = base.get(requestSpecification, "/incident");
	}

	public void getIncident(RequestSpecification requestSpecification, String sysId) {		
		response = base.get(requestSpecification, "/incident/"+sysId);
	}

	public void getIncidetsByCategory(RequestSpecification requestSpecification, String category) {
		response = base.get(requestSpecification
				.queryParam("sysparm_query", "category="+category),
				"/incident");
	}

	public void createIncident(RequestSpecification requestSpecification, Object payload) {
		response = base.post(requestSpecification, "/incident", payload);
	}

	public void createIncident(Map<String, String> headers) {
		response = base.post(requestSpecification, "/incident");
	}

	public void validateResponse(int statusCode, String statusLine) {
		MatcherAssert.assertThat(statusCode, Matchers.equalTo(response.getStatusCode())); 
		MatcherAssert.assertThat(statusLine, Matchers.equalTo(response.getStatusMessage()));
	}
	
	public void validateResponseContentType(String contentType) {
		MatcherAssert.assertThat(contentType, Matchers.equalTo(response.getContentType()));
	}
	
	public String responseAsString() {
		return response.getBody();
	}

}