package day2;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
//import io.restassured.internal.support.FileReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


//different ways to create post request body
//1. using HsahMap
//2. using Org.json
//3. using POJO Class
//4. using external json file data



public class WaysToCreatePostRequestBody {
	
	int id ;
	
	// using HashMap
	//@Test(priority = 1)
	public void testPostUsingHashMap()
	{
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "Arjun");
		data.put("age", 29);
		data.put("grade", "9th");
		String subjectArr [] = {"Java","puthon","Rest Assured"};
		data.put("subjects", subjectArr);
		
		id = given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getInt("id");
		
//		.then()
//			.statusCode(201)
//			.body("name",equalTo("Arjun"))
//			.body("age",equalTo(29))
//			.body("subjects[0]",equalTo("Java"))
//			.body("subjects.size()",equalTo(3))
//			
//			.header("Content-Type","application/json; charset=utf-8")
//			.log().all();
			
					
	}
	
	@Test(priority = 2)
	void getAllStudents()
	{
		given()
			.contentType("application/json")
		
		.when()
			.get("http://localhost:3000/students")
		
		.then()
			.statusCode(200)
			.log().all();

	}
	
	
	@Test(priority = 3)
	void testDelete()
	{
		
		System.out.println("The ID that is goin to be deleted is : "+id);
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	// Post request body using org.json library
		//@Test(priority = 1)
		public void testPostUsingOrgJsonLibrary()
		{
			String subjectArr [] = {"Thermal","GYM","Riding"};
			JSONObject data = new JSONObject();
			data.put("name","Vijay");
			data.put("age",31);
			data.put("grade","BE");
			data.put("subjects", subjectArr);
			
			
			 given()
				.contentType("application/json")
				.body(data.toString())
				
			.when()
				.post("http://localhost:3000/students")
				//.jsonPath().getInt("id");
			
			.then()
				.statusCode(201)
				.body("name",equalTo("Vijay"))
				.body("age",equalTo(31))
				.body("subjects[0]",equalTo("Thermal"))
				.body("subjects.size()",equalTo(3))
				
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
				
						
		}
		
		
		// Post request body using POJO class
				//@Test(priority = 1)
				public void testPostUsingPOJOClass()
				{

					String subjectArr [] = {"QA","Selenium","Rest assured"};
					
					POJO_PostRequest data = new POJO_PostRequest();
					data.setName("Raja");
					data.setAge(30);
					data.setGrade("B>E Production");
					data.setSubjects(subjectArr);
					
					
					
					
					
					 given()
						.contentType("application/json")
						.body(data)
						
					.when()
						.post("http://localhost:3000/students")
						//.jsonPath().getInt("id");
					
					.then()
						.statusCode(201)
						.body("name",equalTo("Raja"))
						.body("age",equalTo(30))
						.body("subjects[0]",equalTo("QA"))
						.body("subjects.size()",equalTo(3))
						
						.header("Content-Type","application/json; charset=utf-8")
						.log().all();
						
								
				}
				
				
				// Post request body using external JSON File
				@Test(priority = 1)
				public void testPostUsingJSONFile() throws FileNotFoundException
				{

					File f = new File(".\\body.json");
					FileReader fr = new FileReader(f);
					JSONTokener jt = new JSONTokener(fr);
					
					JSONObject data = new JSONObject(jt);					
					
					
					 given()
						.contentType("application/json")
						.body(data.toString())
						
					.when()
						.post("http://localhost:3000/students")
						//.jsonPath().getInt("id");
					
					.then()
						.statusCode(201)
						.body("name",equalTo("Arjun Vijayaraja"))
						.body("age",equalTo(30))
//						d
						
						.header("Content-Type","application/json; charset=utf-8")
						.log().all();
						
								
				}
	
	

}
