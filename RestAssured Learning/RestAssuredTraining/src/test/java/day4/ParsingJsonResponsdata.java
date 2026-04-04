package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingJsonResponsdata{
	
	//@Test(priority = 1)
	void testJsonResponseApproach1()
	{
		//Approach 1		
		given()
			.contentType("application/json")
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("products[3].name",equalTo("Coffee Maker"));
			//.log().body();			
	}
	
	@Test(priority=2)
	void testJsonResponseApproach2()
	{
		//approach2
		Response res = given()
			.contentType("application/json")
		
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200);  // validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8"); //validation 2
		String prodName = res.jsonPath().get("products[3].name").toString();
		Assert.assertEquals(prodName,"Coffee Maker");
		
			
	}

}
