package crud_operations;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetOperation {
	
	@Test(priority =1)
	void getAllData()
	{
		given()
		.when()
			.get(" http://localhost:3000/products")
		.then()
			.log().body();
	}

}
