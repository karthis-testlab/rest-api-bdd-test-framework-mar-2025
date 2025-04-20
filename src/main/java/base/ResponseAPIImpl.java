package base;

import java.util.HashMap;
import java.util.Map;

import design.ResponseAPI;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ResponseAPIImpl implements ResponseAPI {
	
	private Response response;
	
	public ResponseAPIImpl(Response response) {
		this.response = response;
	}

	@Override
	public int getStatusCode() {		
		return response.getStatusCode();
	}	

	
	public String getStatusMessage() {
		String[] strings = response.getStatusLine().split(" ", 3);// HTTP1.1 404 Not Found		
		return strings[strings.length - 1]; // ["HTTP1.1", "404", "Not Found"] 
	}

	@Override
	public String getBody() {		
		return response.asPrettyString();
	}

	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> map = new HashMap<>();
		Headers headers = response.getHeaders();
		for (Header header : headers) {
			map.put(header.getName(), header.getValue());
		}
		return map;
	}

	@Override
	public String getContentType() {
		return response.getContentType().split(";")[0];
	}	

}