package step.defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class IncidentGetMethodStep {

	Response response;

	@Given("set base uri of the service now api using the static variable")
	public void set_base_uri_of_the_service_now_api_using_the_static_variable() {
		baseURI = "https://dev265761.service-now.com";
	}

	@Given("set base path of the service now api using the static variable")
	public void set_base_path_of_the_service_now_api_using_the_static_variable() {
		basePath = "/api/now/table";
	}

	@Given("set basic authentication of the serivce now api using the static variable")
	public void set_basic_authentication_of_the_serivce_now_api_using_the_static_variable() {
		authentication = basic("admin", "d@9IvhOh5DR*");
	}

	@When("user hit the get method of the incident table")
	public void user_hit_the_get_method_of_the_incident_table() {
		response = get("/incident");
	}

	@Then("user should see the all records of the incident table")
	public void user_should_see_the_all_records_of_the_incident_table() {
		response.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON);
	}

}