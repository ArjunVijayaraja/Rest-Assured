package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test(priority = 1)
	void testLogs()
	{
		given()
			.header("x-api-key","reqres_ad6479030f37435d90a6e2a5dc19c7e8")
			.pathParam("path", "users")
			.queryParam("page", 2)
		
		.when()
			.get("https://reqres.in/api/{path}")
			
			
		.then()
			//.log().all();
			//.log().body();
			//.log().cookies();
				.log().headers();
	}

}
