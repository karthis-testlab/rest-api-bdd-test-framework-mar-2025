package design;

import io.restassured.specification.RequestSpecification;

public interface ApiClient {
	
	ResponseAPI get(RequestSpecification request);
	ResponseAPI get(RequestSpecification request, String endPoint);
	ResponseAPI post(RequestSpecification request, String endPoint);
	ResponseAPI post(RequestSpecification request, String endPoint, Object body);	
	ResponseAPI put(RequestSpecification request, String endPoint, Object body);
	ResponseAPI patch(RequestSpecification request, String endPoint, Object body);
	ResponseAPI delete(RequestSpecification request, String endPoint);

}