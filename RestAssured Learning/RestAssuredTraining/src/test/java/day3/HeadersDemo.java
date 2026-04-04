package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	//will  get only one header
	@Test(priority = 1)
	void testHeader()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding",  "gzip")
			.and()
			.header("Server","gws")
			.log().all();
		
	}
	
	//will get all the headers
	@Test(priority = 2)
	void testHeaders()
	{
		
		Response res = given()
							.when()
								.get("https://www.google.com/");
		
		Headers headers = res.getHeaders();
		System.out.println("Total number of Heaaders -:> "+ headers.size());
		
		for(Header h : headers ) 
		{
			System.out.println(h.getName()+" ----> "+h.getValue());
		}
		
	}
	

}
