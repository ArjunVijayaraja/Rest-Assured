package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
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
	
	
	// This is the best approach
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
	
	
	//In this method we are making use oh --JSONObjest-- Class
	@Test(priority = 3)
	void testJsonResponseusingBodyData()
	{
		Response res = given()	
						.contentType("application/json")
		.when()
			.get("http://localhost:3000/store");
		/*Assert.assertEquals(res.contentType(),"application/json; charset=utf-8");
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.jsonPath().get("products[3].name").toString(),"Coffee Maker");
		System.out.println(res.getContentType());*/
		
		
		JSONObject jo = new JSONObject(res.asString());  //Converting the res to JSONObject type (using asString)
		//printing all the product name
		boolean status = false;
		for(int i=0;i<jo.getJSONArray("products").length();i++)
		{
			String p_id =jo.getJSONArray("products").getJSONObject(i).get("product_id").toString();
			String productName =jo.getJSONArray("products").getJSONObject(i).get("name").toString();
			System.out.println(p_id+" - "+productName);
						
			if(productName.equalsIgnoreCase("Bluetooth Headphones"))
			{
				status = true;
				break;				
			}		
		}
		Assert.assertEquals(status, true);	
		
	}
	
	//Validating total price of the products
	@Test(priority = 4)
	void validateTotalProductPrice()
	{
		Response res = given()
						.when()
							.get("http://localhost:3000/store");
		
		JSONObject jo = new JSONObject(res.asString());
		double totalPrice = 0;
		for(int i=0;i<jo.getJSONArray("products").length();i++)
		{
			String productPrice =jo.getJSONArray("products").getJSONObject(i).get("price").toString();	
			totalPrice = totalPrice + Double.parseDouble(productPrice);
		}
		
		System.out.println("Sum of All the product Price : "+totalPrice);
		Assert.assertEquals(totalPrice,461.48);
		
		
	}
	
	
	

}
