package day6;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class JSONSchemeValidations {
	
	@Test(priority = 1)
	void jsonSchemaValidation()
	{
		
		
		JSONObject jb = new JSONObject();
		//jb.put("id", 6);
		jb.put("product_id", "P1006");
		jb.put("name", "LAPTOP IdeaPad S540");
		jb.put("category", "electronics");
		jb.put("brand", "Lenovo");
		jb.put("price",90000);
		jb.put("stock", 2);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jb.toString())
		.when()	
			.post("http://localhost:3000/products")
		.then()
			.statusCode(201);
		
	}

} 
