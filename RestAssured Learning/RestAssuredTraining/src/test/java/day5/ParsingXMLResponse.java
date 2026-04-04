package day5;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class ParsingXMLResponse {
	
	@Test(priority = 1)
	void testXMLResponse()
	{
		//Approach 1 - without using the responseData

		given()
			
		.when()
			.get("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.quakeml")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.log().body();
	}

}
