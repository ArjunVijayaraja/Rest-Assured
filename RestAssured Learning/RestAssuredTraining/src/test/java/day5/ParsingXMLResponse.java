package day5;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingXMLResponse {
	
	@Test(priority = 1)
	void testXMLResponse()
	{
		//Approach 1 - without using the responseData

		given()
			.queryParam("page", 1)
			
		.when()
			.get("https://mp06fa46fdb1e3988ab7.free.beeceptor.com/data")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml")
			.body("TravelerinformationResponses.PageResponse.travelers.Travelerinformation[0].name",equalTo("User 1"))
			.log().body();
	}
	
	@Test(priority =2)
	void testXMLResponseUsinngResponseBody()
	{
		Response res = given()
						.when()
							.get("https://mp06fa46fdb1e3988ab7.free.beeceptor.com/data");
		
		Assert.assertEquals(res.statusCode(),200);
	// String 	res.xmlPath().get("")
		//THis this topic is yet to be studied...
	}
	

}
