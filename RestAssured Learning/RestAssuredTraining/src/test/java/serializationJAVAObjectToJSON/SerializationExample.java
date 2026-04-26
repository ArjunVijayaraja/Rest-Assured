package serializationJAVAObjectToJSON;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationExample {
	
	@Test(priority =1)
	void sendData()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		PlaceData data = new PlaceData();
		Location loc = new Location();
		List<String> type = new ArrayList<String>();
		type.add("shoe park");
		type.add("shop");
		loc.setLat("-38.383494");
		loc.setLng("427362");
		data.setLocation(loc);
		data.setAccuracy(50);
		data.setName("Frontline house");
		data.setPhone_number("(+91) 983 893 3937");
		data.setAddress("29, side layout, cohen 09");
		data.setTypes(type);
		data.setWebsite("http://google.com");
		data.setLanguage("French-IN");
		
		
		
		String res = given()
			.queryParam("key", "qaclick123")
			.body(data)
		.when()
			.post("/maps/api/place/add/json")
		.then()
			.log().body().extract().response().asString();
		
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		
		System.out.println("The Status is : "+js.getString("status"));
		System.out.println("The place id is :" +js.getString("place_id"));
		
		
	}

}
