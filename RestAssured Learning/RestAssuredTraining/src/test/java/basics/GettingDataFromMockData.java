package basics;

import org.testng.annotations.Test;

import files_rs.PayLoad;
import io.restassured.path.json.JsonPath;
import reuseableMethods.ReUseablemethods;

import  static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GettingDataFromMockData {

	
	@Test(priority = 1)
	void getCourseDatas()
	{
		JsonPath res =ReUseablemethods.RawTOJson(PayLoad.coursePrice());
		int courseCount = res.getInt("courses.size()");
		System.out.println("total number of course : "+courseCount);
		
		//print Purchase AMount
		int purchaseAMount = res.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount of the  course : "+purchaseAMount);

		//Print title of first course
		String firstCourseTitle = res.getString("courses[0].title");
		System.out.println("Title of First Course : "+firstCourseTitle);
		
		//print all courses titles and respective prices
		for(int i = 0;i< courseCount;i++) {
			System.out.println(res.getString("courses["+i+"].title") + " : "+ res.getInt("courses["+i+"].price"));
		}
		
		//Print no of copies sold by RPA COurse
		String c = "RPA";
		for(int i = 0;i< courseCount;i++) {
			if(res.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				System.out.println("Coppies sold by " +res.getString("courses["+i+"].title") +" : " + res.getInt("courses["+i+"].copies"));
			}
			
			
		}

		
	}
}
