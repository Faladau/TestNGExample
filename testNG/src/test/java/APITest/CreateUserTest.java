package APITest;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import dataProvider.DataTesting;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class CreateUserTest {
	public String baseURL = "https://reqres.in/";
	Utile utils = new Utile();
	
	
	@Test(dataProvider = "New Users", dataProviderClass = DataTesting.class)
	public void testUsers(String dataTestingName, String dataTestingJob, int status) {
		
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		String userName = dataTestingName;
		String job = dataTestingJob;
		
		Response response =  httpRequest.body(utils.createUserJson(userName, job)).post("/api/users");

		assertEquals(response.getStatusCode(), status, "Invlid stauts code!");
				
//		response.then().body("name", Matchers.<String>is(dataTestingName)).and().body("job", Matchers.<String>is(dataTestingJob));
		
		System.out.println(response.asString());
		
	}

}
