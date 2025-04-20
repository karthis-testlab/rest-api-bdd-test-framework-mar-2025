package steps.def.som.base;

import static io.restassured.RestAssured.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.ResponseAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;

import servicenow.models.InicidentReqPayload;
import servicenow.services.base.IncidentService;

public class IncidentPostMethod {
	
	ResponseAPI response;	
	InicidentReqPayload payload = new InicidentReqPayload();
	Map<String, String> headers = new HashMap<String, String>();
	String request_payload = """
			{
             "short_description": "RESTAPISessionMAR2025",
             "description": "Create new record using Post method"
            }
			""";	
	
	IncidentService incident = new IncidentService();
	
	RequestSpecBuilder builder = new RequestSpecBuilder();			
	
	private TestContext context;
	
	public IncidentPostMethod(TestContext context) {
		this.context = context;
	}

	@Given("set base uri of the service now api")
	public void set_base_uri_of_the_service_now_api() {
		builder.setBaseUri("https://dev265761.service-now.com");	   
	}

	@Given("set base path of the service now api")
	public void set_base_path_of_the_service_now_api() {
		builder.setBasePath("/api/now/table");
	}

	@Given("set basic authentication of the serivce now api")
	public void set_basic_authentication_of_the_serivce_now_api() {
		builder.setAuth(basic("admin", "d@9IvhOh5DR*"));
	}

	@When("Set the header {string} key and {string} as value")
	public void set_the_header_key_and_as_value(String key, String value) {
		builder.addHeader(key, value);
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
		incident.createIncident(builder.build(), payload);
	}

	@Then("validate the status code and status line")
	public void validate_the_status_code_and_status_line(DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();		
		try {
			incident.validateResponse(Integer.parseInt(asMap.get("StatusCode")), asMap.get("StatusLine"));	
			incident.validateResponseContentType("application/json");
		} catch (AssertionError e) {
			context.setContext("response", incident.responseAsString());
			context.setContext("error", e.getLocalizedMessage());
			context.setContext("trace", Arrays.toString(e.getStackTrace()).replace( ',', '\n' ));
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
	}
	
	@When("user set the headers of the the service now api")
	public void user_set_the_headers_of_the_the_service_now_api(DataTable dataTable) {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    for (Map<String, String> map : asMaps) {
	    	builder.addHeader(map.get("Key"), map.get("Value"));
		}
	}
	
	@When("hit the post http method with request body as the string object")
	public void hit_the_post_http_method_with_request_body_as_the_string_object() {
		incident.createIncident(builder.build(), request_payload);
	}

}