package reuseableMethods;

import io.restassured.path.json.JsonPath;

public class ReUseablemethods{
	
	public  static JsonPath RawTOJson(String response)
	{
		JsonPath jsonPath = new JsonPath(response);
		return jsonPath;
	}	
}
