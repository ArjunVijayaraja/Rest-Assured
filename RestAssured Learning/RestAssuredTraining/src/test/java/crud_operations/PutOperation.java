package crud_operations;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers.*;
import org.json.JSONObject;

import io.restassured.matcher.RestAssuredMatchers.*;

public class PutOperation {

	
	@Test(priority=1)
	void updataData() {
		

		JSONObject jb = new JSONObject();
		//jb.put("id", 6);
		jb.put("product_id", "P1007");
		jb.put("name", "LAPTOP IdeaPad S640");
		jb.put("category", "electronics");
		jb.put("brand", "Lenovo");
		jb.put("price",88000);
		jb.put("stock", 2);
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jb.toString())
		.when()	
			.put("http://localhost:3000/products/7")
		.then()
			.statusCode(200);
		
		
	}
}
