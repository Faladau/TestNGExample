package APITest;
import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsers {
	public String baseURL = "https://reqres.in/";
	Utile utils = new Utile();

	
	@Test
	public void getUserTestNG() {
		//navigate to home page and get users from page 2
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		
		Response response = httpRequest.request(Method.GET, "/api/users");
		Response response1 = httpRequest.request(Method.GET, "/api/users/13");
		Response response2 = httpRequest.request(Method.GET, "/api/users/2");


		
		
//		System.out.println(response.statusCode());
//		System.out.println(response.getBody().asString());
//		System.out.println(response.prettyPrint());
//		response.prettyPrint();
		
		assertEquals(response.statusCode(), 200, "Invlid stauts code!");

		assertEquals(response1.statusCode(), 404, "Invlid stauts code!");
		
		assertEquals(response2.statusCode(), 200, "Invlid stauts code!");

		String FirstName = response.getBody().asString();
		Assert.assertTrue(FirstName.contains("Janet"));
		
		String LastName = response.getBody().asString();
		Assert.assertTrue(LastName.contains("Weaver"));
			
		String id = response.getBody().asString();
		Assert.assertTrue(id.contains("2"));

		String avatar = response.getBody().asString();
		Assert.assertTrue(avatar.contains("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));

		
		response.getBody().asString();
		String FirstName2 = (String) utils.getUserDataFromJson(response2.getBody().asString(), "first_name");
		assertEquals(FirstName2, "Janet", "Invlid stauts code!");

		String LastName2 = (String) utils.getUserDataFromJson(response2.getBody().asString(), "last_name");
		assertEquals(LastName2, "Weaver", "Invlid stauts code!");
		
				
	}
	
	
	@Test
	public void getUserTestAssured() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		
	
		RestAssured.
		   given().header(contentType).
		   when().get("/api/users").
		   then().statusCode(200);
			
	}
	
	@Test
	public void getAllUsers() {
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);

		Response response = httpRequest.request(Method.GET, "/api/users");
				
		int nrUsers = Integer.parseInt(utils.getUserDataFromJson(response.asString(), "total").toString());
		
		System.out.println(nrUsers);
		
		for (int i = 0; i <= nrUsers; i++) {
			Response response2 = httpRequest.request(Method.GET, "/api/users/"+i);
			Assert.assertTrue( Integer.parseInt(utils.getUserDataFromJson(response2.asString(), "id").toString()) == i);

		}
		
	}
	
	@Test
	public void createUser() {
		
		RestAssured.baseURI = baseURL;
		Header contentType = new Header("Content-type", "application/json; charset=UTF-8");
		RequestSpecification httpRequest = RestAssured.given().header(contentType);
		String userName = "Iogi";
		String job = "QA";
		Response response =  httpRequest.body(utils.createUserJson(userName, job)).post("/api/users");
		
		assertEquals(response.getStatusCode(), 201, "Invlid stauts code!");
				
		response.then().body("name", Matchers.<String>is("Iogi")).and().body("job", Matchers.<String>is("QA"));
		
		System.out.println(response.asString());

	}
	
	
	
	

}
