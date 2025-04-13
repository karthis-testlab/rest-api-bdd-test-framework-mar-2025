package step.defs;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import models.InicidentReqPayload;

public class IncidentPostMethod {
	
	Response response;	
	InicidentReqPayload payload = new InicidentReqPayload();
	Map<String, String> headers = new HashMap<String, String>();

	@Given("set base uri of the service now api")
	public void set_base_uri_of_the_service_now_api() {
		baseURI = "https://dev265761.service-now.com";
	}

	@Given("set base path of the service now api")
	public void set_base_path_of_the_service_now_api() {
		basePath = "/api/now/table";
	}

	@Given("set basic authentication of the serivce now api")
	public void set_basic_authentication_of_the_serivce_now_api() {
		authentication = basic("admin", "d@9IvhOh5DR*");
	}

	@When("Set the header {string} key and {string} as value")
	public void set_the_header_key_and_as_value(String key, String value) {
		headers.put(key, value);
	}

	@When("create the incident record with description {string} in the request body")
	public void create_the_incident_record_with_description_in_the_request_body(String description) {
		payload.setDescription(description);
	}

	@When("create the incident record with short description {string} in the request body")
	public void create_the_incident_record_with_short_description_in_the_request_body(String shortDescription) {
		payload.setShort_description(shortDescription);
	}

	@When("hit the post http method with request body as the pojo object")
	public void hit_the_post_http_method_with_request_body_as_the_pojo_object() {
		response = given()
				   .headers(headers)
				   .log().all()
				   .body(payload)
				   .post("/incident");
	}

	@Then("validate the status code and status line")
	public void validate_the_status_code_and_status_line() {
		response.then()
		.assertThat()
		.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		.contentType(ContentType.JSON);
	}

}