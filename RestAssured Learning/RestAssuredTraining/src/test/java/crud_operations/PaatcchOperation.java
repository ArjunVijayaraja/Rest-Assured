package crud_operations;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PaatcchOperation {

	
	@Test(priority=1)
	void getDataBeforeUpdate() {
		Response res = given() 
						.when()
							.get("http://localhost:3000/products/7");
		String existingProdName = res.jsonPath().get("name").toString();
		String actualProdName = "LAPTOP IdeaPad S640";
						
		Assert.assertEquals(existingProdName,actualProdName);
		System.out.println("----------BEFOR UPDATE----------");
		System.out.println("Existing Name : "+existingProdName);
		System.out.println("Actual name : "+actualProdName);
		System.out.println();
	}
	
	@Test(priority=2)
	void patchData() {
			

			JSONObject jb = new JSONObject();
			//jb.put("product_id", "P1007");
			jb.put("name", "WORKBOOK");
			
			
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jb.toString())
			.when()	
				.patch("http://localhost:3000/products/7")
			.then()
				.statusCode(200);
			
	}
	
	@Test(priority=3)
	void getDataAfterUpdate() {
		Response res = given() 
						.when()
							.get("http://localhost:3000/products/7");
		String existingProdName = res.jsonPath().get("name").toString();
		String actualProdName = "WORKBOOK";
						
		Assert.assertEquals(existingProdName,actualProdName);
		System.out.println("--------------------AFTER UPDATE----------------");
		System.out.println("Updated Name : "+existingProdName);
	}
	
	
}
