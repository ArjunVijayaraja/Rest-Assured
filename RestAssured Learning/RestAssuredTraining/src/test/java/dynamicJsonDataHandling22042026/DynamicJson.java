package dynamicJsonDataHandling22042026;

import org.testng.annotations.Test;

import files_rs.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reuseableMethods.ReUseablemethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DynamicJson {
	
	//@Test(priority =1)
	void addBook()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String res = given()
			.header("Content-Type","application/json")
			.body(PayLoad.addBook())
		.when()
			.post("/Library/Addbook.php")
		.then()
			//.log().all()
			.assertThat()
			.statusCode(200)
			.extract().response().toString();		
		
	}
	
	@Test(priority =2)
	void assBookWithDynamicData()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String res =  given()
			.header("Content-Type","application/json")
			.body(PayLoad.addBook("qwert", "bbj",8,"uiiRS"))
		.when()
			.post("Library/Addbook.php")
		.then()
			.log().all()
			.assertThat()
			.statusCode(200)
			.extract().response().asString();
		
		JsonPath js = ReUseablemethods.RawTOJson(res);
		
		
		//getting the details using ID		
		given()
		.header("Content-Type","application/json")
		.queryParam("ID", js.getString("ID"))
		.when()
		.get("/Library/GetBook.php")
		.then()
		.log().all();
		
		//deleting the book using ID
		
		String delRes = given()
			.header("Content-Type","application/json")
			.body("{\r\n"
					+ "\"ID\":\""+js.getString("ID")+"\"\r\n"
					+ "}"
					)
		.when()
			.post("/Library/DeleteBook.php")
		.then()
			.log().all().assertThat().extract().response().asString();
		
		JsonPath delJs = ReUseablemethods.RawTOJson(delRes);
		System.out.println(delJs.getString("msg"));
		
		
	
		
		
			
	}
	
	

}
