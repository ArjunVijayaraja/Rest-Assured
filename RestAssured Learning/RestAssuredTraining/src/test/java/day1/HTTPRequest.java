package day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

/*given()
   content type, set cookies, add authentication, add parameter, set header info etc...
  
when()
	get, put, post, delete

then()
	validate status code, extract response, extract headers cookies and response bodies etc...
*/

public class HTTPRequest {
	
	@Test(priority = 1)
	void getUsers()
	{
		given()
		.header("x-api-key", "reqres_ad6479030f37435d90a6e2a5dc19c7e8")
		.log().all()
			
			
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		 	.statusCode(200)
		 	.body("page",equalTo(2))
		 	.log().all();
	}
	
	@Test
	void createUser()
	{
		Map<String, String> data = new HashMap();
		data.put("email", "eve.holt@reqres.in");
		data.put("password", "pistol");
		
		
		
		given()
			.header("x-api-key", "reqres_ad6479030f37435d90a6e2a5dc19c7e8")
			.contentType("application/json")
			.body(data)
			
			
		.when()
			.post("https://reqres.in/api/register")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	

}
