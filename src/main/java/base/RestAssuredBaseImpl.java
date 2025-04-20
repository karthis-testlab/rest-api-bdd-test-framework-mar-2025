package base;

import design.ApiClient;
import design.ResponseAPI;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RestAssuredBaseImpl implements ApiClient {	
		
	@Override
	public ResponseAPI get(RequestSpecification request) {	
		return new ResponseAPIImpl(given().spec(request).get());
	}

	@Override
	public ResponseAPI get(RequestSpecification request, String endPoint) {
		return new ResponseAPIImpl(given().spec(request).get(endPoint));
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint) {		
		return new ResponseAPIImpl(given().spec(request).post(endPoint));
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, Object body) {
		return new ResponseAPIImpl(given().spec(request).body(body).post(endPoint)); 
	}

	@Override
	public ResponseAPI put(RequestSpecification request, String endPoint, Object body) {		
		return new ResponseAPIImpl(given().spec(request).body(body).put(endPoint));
	}

	@Override
	public ResponseAPI patch(RequestSpecification request, String endPoint, Object body) {		
		return new ResponseAPIImpl(given().spec(request).body(body).patch(endPoint)); 
	}

	@Override
	public ResponseAPI delete(RequestSpecification request, String endPoint) {		
		return new ResponseAPIImpl(given().spec(request).delete(endPoint)); 
	}

}