package jiraAPI_usingBasicAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.util.Properties;

public class CreatingBugWithAttachmentUsingJIRAapi {

	@Test
	void createBug()
	{
		Properties prop = new Properties();
		RestAssured.baseURI = "https://arjunvijayarajab.atlassian.net/";
		try {
			FileInputStream fis = new FileInputStream("config.properties");
			prop.load(fis);
			String token = prop.getProperty("auth.token");
			
			String res = given()
			.header("Content-Type","application/json")
			.header("Authorization",token)
			.body("{\r\n"
					+ "    \"fields\": {\r\n"
					+ "       \"project\":\r\n"
					+ "       {\r\n"
					+ "          \"key\": \"QA\"\r\n"
					+ "       },\r\n"
					+ "       \"summary\": \"Dropdown Not working  in other screens this is from AUtomation Code\",\r\n"
					+ "       \"issuetype\": {\r\n"
					+ "          \"name\": \"Bug\"\r\n"
					+ "       }\r\n"
					+ "   }\r\n"
					+ "}\r\n"
					+ "")
			.log().all()
			.when()
			.post("rest/api/3/issue")
			.then()
			.log().all()
			.assertThat().statusCode(201).extract().response().asString();
			
			JsonPath js = new JsonPath(res);
			String issueID = js.getString("id");
			
			
			
			
			
			
		}catch(Exception e)
		{
			
		}
		
		
//		given()
		//.headers("Content-Type","application/json")
		//.headers("Authentication","Basic YXJqdW52aWpheWFyYWphYkBnbWFpbC5jb206QVRBVFQzeEZmR0YwdVNLNnBIRURqcWhLMmI4dW9HZktqc1NCXzk5YXNKT05HTUpfRThsNlZXMmNwRm9CT2QyNGhKZW9zSU5ibXA4bkFGdjEzYVA5NXhmTmg1RHpsV0lZNV94bVZZUWg1c1Jwb19ZS04wZGJ2SVlpbEh5OTBUYzJCMVJ3X2lJVHMwNXVjLS10UGI2anFEeVZfZ2NDLWhWRDBlSTJjQzBwSkplUlRrMXdXZ2otYnVrPTZERjE3N0U0")
	}
	
}
