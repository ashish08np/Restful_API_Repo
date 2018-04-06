package restassuredproject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getResponse {
	
	@Test
	public void exampleRestTest(){
		Response res = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1");
		String responsedata = res.asString();
		
		
	}

}
