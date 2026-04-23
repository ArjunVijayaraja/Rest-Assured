package dynamicJsonDataHandling22042026;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonParseException;

import files_rs.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import reuseableMethods.ReUseablemethods;



public class AddDataUsingFataProviders {
	
	@Test(dataProvider = "BooksData",priority =1)
	void addBook(String bookName, String isbn, int asileNumber, String author)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		System.out.println("------------Adding Data-----------------");
		String res = given()
				.header("Content-Type","application/json")
				.body(PayLoad.addBook(bookName, isbn, asileNumber, author))
		.when()
			.post("Library/Addbook.php")
		.then()
			//.log().all()
			.extract().response().asString();
		JsonPath js = new JsonPath(res);
		System.out.println("the id is "+js.getString("ID"));
		System.out.println("-------------Getting Data----------------");
		//Getting the Book Details using ID		
		given()
			.header("Content-Type","application/json")
			.queryParam("ID", js.getString("ID"))
		.when()
			.get("Library/GetBook.php")
		.then()
			.log().body();

		System.out.println("-------------Deleting Data----------------");
		//Deleting the Book using the ID
		String delRes = given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+"\"ID\":\""+js.getString("ID")+"\"\r\n"
				+"}")
		.when()
			.post("/Library/DeleteBook.php")
		.then()
			//.log().all()
			.extract().response().asString();
		
		JsonPath delJs = new JsonPath(delRes);
		System.out.println(delJs.getString("msg"));
		
		
		
		
		
		
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getBooks(){
		return new Object[][] {{"TEST BOOK 1","ISBN",1,"Author_1"},{"TEST BOOK 2","ISBN",2,"Author_2"},
			{"TEST BOOK 3","ISBN",3,"Author_3"},{"TEST BOOK 4","ISBN",4,"Author_4"}};
	}

}
