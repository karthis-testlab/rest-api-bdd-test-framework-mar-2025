package step.defs;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentGetMethodQueryParam {

	Response response;
	RequestSpecBuilder builder = new RequestSpecBuilder();

	@Given("set base uri of the service now api using the responsespecbuilder")
	public void set_base_uri_of_the_service_now_api_using_the_responsespecbuilder() {
		builder.setBaseUri("https://dev265761.service-now.com");
	}

	@Given("set base path of the service now api using the responsespecbuilder")
	public void set_base_path_of_the_service_now_api_using_the_responsespecbuilder() {
		builder.setBasePath("/api/now/table");
	}

	@Given("set basic authentication of the serivce now api using the responsespecbuilder")
	public void set_basic_authentication_of_the_serivce_now_api_using_the_responsespecbuilder() {
		builder.setAuth(basic("admin", "d@9IvhOh5DR*"));
	}

	@Given("Set the header {string} key and {string} as value using the responsespecbuilder")
	public void set_the_header_key_and_as_value_using_the_responsespecbuilder(String key, String value) {
		builder.addHeader(key, value);
	}

	@Given("set the query parameter {string} key and {string} value to filter response")
	public void set_the_query_parameter_key_and_value_to_filter_response(String key, String value) {
		builder.addQueryParam(key, value);
	}
	
	@When("user hit the get method of the incident table with the responsespecbuilder")
	public void user_hit_the_get_method_of_the_incident_table_with_the_responsespecbuilder() {
		response = given()
				   .spec(builder.build())
				   .log().all()
				   .get("/incident");
	}
	
	@Then("user should see the all records of the incident table using query parameter")
	public void user_should_see_the_all_records_of_the_incident_table_using_query_parameter() {
		response.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON);
	}

}