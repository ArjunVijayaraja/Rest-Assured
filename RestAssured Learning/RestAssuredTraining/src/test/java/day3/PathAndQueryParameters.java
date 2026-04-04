package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {
	
	//https://reqres.in/api/products?page=1
	
	
	@Test
	void testQueryAndpathParameters()
	{
		given()
			.header("x-api-key","reqres_ad6479030f37435d90a6e2a5dc19c7e8")
			.pathParam("myPath", "products") //path parameters
			.queryParam("page",2) // query parameter
			.queryParam("id", 8)
			
		
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
