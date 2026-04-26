package serializationAndDeserializationUsingPOJOclass;

import static io.restassured.RestAssured.given;

import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class Serialization_GetDataUsingPOJOclass {
	
	@Test(priority =1)
	void getCouseDetails() 
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		Properties prop = new Properties();
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(is);
			
			String res = given()
				.formParam("client_id", prop.getProperty("auth.client_id"))
				.formParam("client_secret",prop.getProperty("auth.client_secret"))
				.formParam("grant_type",prop.getProperty("auth.grant_type"))
				.formParam("scope",prop.getProperty("auth.scope"))
			.when()
				.post("oauthapi/oauth2/resourceOwner/token")
			.then()
				.log().all().assertThat().statusCode(200).extract().response().asString();
			
			JsonPath js = new JsonPath(res);
			String token = js.getString("access_token");
			System.out.println("The Token is : "+token);
			
			Instructor_POJOclass instructor = given()
				.queryParam("access_token",token).expect().defaultParser(Parser.JSON)
			.when()
				.get("oauthapi/getCourseDetails").as(Instructor_POJOclass.class);
			
			System.out.println(instructor.getInstructor());
			System.out.println(instructor.getLinkedIn());
			System.out.println(instructor.getCourses().getWebAutomation().get(0).getCourseTitle());
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
