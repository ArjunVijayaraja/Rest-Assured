package basics;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import files_rs.PayLoad;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reuseableMethods.ReUseablemethods;

import java.util.HashMap;
import java.util.Map;

public class Basics {
	
	//given - all input details
	//when - Submit the API  -- resource and http methods will go under WHEN method
	//then - validate the response
	//@Test(priority = 1)
	void basicFunnctions()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		given()
			.queryParam("key", "qaclik123")
			.contentType("application/json")
			//.log().all()
			.body(PayLoad.addPlace())
		.when()
			.post("maps/api/place/add/json")
			
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.body("scope",equalTo("APP"))
			.header("Server", equalTo("Apache/2.4.52 (Ubuntu)"));		
	}
	
	//Add Place
	//Update place with new address
	// get place using a newly created id of of add place
	
	
	
	//Parsing the JSON Response using JsonPath
	//@Test(priority = 2)
	void addNewPlaceAndStroreTheResponseInVariabel ()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
			String res = given()
						.queryParam("key", "qaclik123")
						.contentType("application/json")
						.body(PayLoad.addPlace())				
					.when()
						.post("maps/api/place/add/json")
					.then()
						.statusCode(200).extract().response().asString();
			
			System.out.println(res);
			JsonPath jp = new JsonPath(res);
			jp.get("place_id");
			System.out.println("REFERENCE : "+jp.getString("reference"));
			System.out.println("PLACE_ID : "+jp.getString("place_id"));;
						
	}
	
	//Parsing the JSON Response using JsonPath
	//Updating the Place using the stored variable
		@Test(priority = 3)
		void updatingTHePlaceUisngTheStoredVariable () throws InterruptedException
		{
			RestAssured.baseURI = "https://rahulshettyacademy.com";
			
				String res = given()
							.queryParam("key", "qaclik123")
							.contentType("application/json")
							.body(PayLoad.addPlace())				
						.when()
							.post("maps/api/place/add/json")
						.then()
							//.log().body()
							.statusCode(200).extract().response().asString();
				
				System.out.println(res);
				JsonPath jp = reuseableMethods.ReUseablemethods.RawTOJson(res);
				//JsonPath jp = new JsonPath(res);
				String placeid = jp.get("place_id");
				System.out.println("REFERENCE : "+jp.getString("reference"));
				System.out.println("PLACE_ID : "+placeid);
				System.out.println();
				
				
				//Thread.sleep(10000);
				String BeforUpadteAddress =	given()
						.queryParam("key", "qaclick123")		
						.queryParam("place_id",placeid)
					.when()
						.get("maps/api/place/get/json")
					.then()
						.assertThat()
						.extract().response().asString();
				System.out.println(BeforUpadteAddress);
				
				JsonPath oldAddres = ReUseablemethods.RawTOJson(BeforUpadteAddress);
				//JsonPath oldAddres = new JsonPath(BeforUpadteAddress);
				
				System.out.println("Address brfore Updatinng ");
			System.out.println("ADDRESS : "+oldAddres.getString("address"));				
			//updating the place using put 
			
			String address = "asdfghjklasdfghjkl test";
				given()
				.queryParam("key", "qaclick123")
				.contentType("application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+jp.get("place_id")+"\",\r\n"
						+ "\"address\":\""+address+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}\r\n"
						+ "")
				.when()
					.put("maps/api/place/update/json")
				.then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
//				
				System.out.println("AFTER UPDATING :");
			String updatedAddress =	given()
				.queryParam("place_id", jp.getString("place_id"))
				.queryParam("key", "qaclick123")				
			.when()
			.get("/maps/api/place/get/json")
			.then()
				.assertThat()
				.extract().response().asString();
			
			JsonPath updatedJp = ReUseablemethods.RawTOJson(updatedAddress);
			//JsonPath updatedJp = new JsonPath(updatedAddress);
			System.out.println("updated Address : "+ updatedJp.getString("address"));
			Assert.assertEquals(updatedJp.getString("address"), address);
							
		}
	
	
	
	

}
