package advacnedExample;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class JasonServerRequest {
	
	@Test
	public void test_01(){
		Response res = given().
		when().
		get("http://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1").
		then().
		statusCode(200).
		statusLine("200").
		contentType(ContentType.JSON).
		extract().response();
		String response = res.asString();
		
		
		
		
		
		
	}

}
