package files_rs;

public  class PayLoad {
	public static String addPlace()
	{
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09..\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String coursePrice() 
	{
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	
	
	//
	public static String addBook()
	{
		return"{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\"bcd\",\r\n"
				+ "\"aisle\":\"2926\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
	}
	
	public static String addBook(String bookName, String isbn, int aisle, String author)
	{
		return "{\r\n"
				+ "\"name\": \""+bookName+"\",\r\n"
				+"\"isbn\" : \""+isbn+"\",\r\n"
				+"\"aisle\": \""+aisle+"\",\r\n"
				+"\"author\" : \""+author+"\"\r\n"
				+ "}";
	}
 
	public static String getStudentMarks()
	{
		return "{\r\n"
				+ "    \"school_name\": \"Dunder Miflin\",\r\n"
				+ "    \"classs\": \"Year 1\",\r\n"
				+ "    \"info\": {\r\n"
				+ "      \"president\": \"Michael Scott\",\r\n"
				+ "      \"address\": \"Scranton, Pennsylvania\",\r\n"
				+ "      \"contacts\": {\r\n"
				+ "        \"email\": \"admin@e.com\",\r\n"
				+ "        \"tel\": \"123456789\"\r\n"
				+ "      }\r\n"
				+ "    },\r\n"
				+ "    \"students\": [\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"A1\",\r\n"
				+ "        \"name\": \"Jim\",\r\n"
				+ "        \"math\": 60,\r\n"
				+ "        \"physics\": 66,\r\n"
				+ "        \"chemistry\": 61\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"A2\",\r\n"
				+ "        \"name\": \"Dwight\",\r\n"
				+ "        \"math\": 89,\r\n"
				+ "        \"physics\": 76,\r\n"
				+ "        \"chemistry\": 51\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"A3\",\r\n"
				+ "        \"name\": \"Kevin\",\r\n"
				+ "        \"math\": 79,\r\n"
				+ "        \"physics\": 90,\r\n"
				+ "        \"chemistry\": 78\r\n"
				+ "    }]\r\n"
				+ "}";
	}
	
}
