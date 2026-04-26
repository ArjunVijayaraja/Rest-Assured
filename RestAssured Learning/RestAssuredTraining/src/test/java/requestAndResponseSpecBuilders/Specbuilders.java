package requestAndResponseSpecBuilders;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import serializationJAVAObjectToJSON.Location;
import serializationJAVAObjectToJSON.PlaceData;

public class Specbuilders {
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
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
								.addQueryParam("key", "qaclick123")
								.setContentType(ContentType.JSON)
								.build();
		
		ResponseSpecification resSpec =	new ResponseSpecBuilder().expectStatusCode(200)
										.expectContentType(ContentType.JSON)
										.build();
		
		RequestSpecification req = given()
						.spec(reqSpec)
						.body(data);
		
		String response =  req.when()
			.post("/maps/api/place/add/json")
		.then()
			.spec(resSpec).log().body().extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		
		System.out.println("The Status is : "+js.getString("status"));
		System.out.println("The place id is :" +js.getString("place_id"));
		
		
	}

}
