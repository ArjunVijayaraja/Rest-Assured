package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class CookiesDemo {

	@Test(priority = 1)
	void testCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.cookie("AEC", "AaJma5svsSb0Ip5RMYjYrhPKf8e_GzCafu-a79TV7aaCxFWgku-scsBwEA")
			.log().all();
		
	}
	
	@Test(priority = 2)
	void grtCookiesInfo()
	{
	 	Response res =  given()
		
		.when()
			.get("https://www.google.com/");
	 	
	 	//How to get single cookie info -- just the info of aec cookie
	 	String AECCookie_Value =	res.getCookie("AEC");
	 	System.out.println("The Value of AEC cookie is ----> "+AECCookie_Value );
	 	
	 	//How to get the values of ALL THE COOKIE that was been generated 
	 	
	 	Map<String,String> cookies = res.getCookies();
	 	
	 	System.out.println(cookies.keySet());
	 	
	 	for(String key :cookies.keySet()) {
	 		System.out.println("The Vlaue of "+ key+" is ----->"+res.getCookie(key));
	 	}
	}
}
