package APITest;

import static org.testng.Assert.assertEquals;

import org.springframework.util.Base64Utils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthentication {

	public String baseURL = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
	
	@Test
	public void noAuthentication() {
		
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response =  httpRequest.get();
		
		assertEquals(response.statusCode(), 401);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());

		
	}
	
	@Test
	public void succsesAuthentication() {
		
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given();

		String user = "ToolsQA";
		String password = "TestPassword";

		Response response = httpRequest.auth().basic(user, password).get();
		 response.prettyPeek();

		
		assertEquals(response.statusCode(), 200);
//		System.out.println(response.statusCode());
//		System.out.println(response.prettyPrint());
		
		
		
	}
	
}
