import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TestNGMode {
	//Gloal variable to use for all methods
	public static String login_token = null;
	
	@Test
	public void postGetAccessToken() throws JSONException {
			
		//Initializing Rest API's URL
		String APIUrl = "https://sgmc-ad-api-uat.mmvpay.com/oauth/access_token";
		//String userName = "flexm-frontend";
		//String password = "N2MxYmRkNTA5MmEwYjQzZWFjNTI5ZTRiNDc0YzA1OGNhZDJlNGU5OTUwMWI2NGE1OWQ3M2Y3MTY1YWUxNDIzMA";

		//String authString = userName + ":" + password;
		//System.out.println("auth string: " + authString);
		//byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		//String authStringEnc = new String(authEncBytes);
		//System.out.println("Base64 encoded auth string: " + authStringEnc);
		
		//Initializing payload or API body
		
	        String grantType="password";
	        String username1="test+1@test.com";
	        String password1="password";
	        String client_id="f3d259ddd3ed8ff3843839b";
	        String client_secret="4c7f6f8fa93d59c45502c0ae8c4a95b";
	           
	      String requestBody = "{\"username\":" + "\"" + username1+ "" + "\",\"password\":" + "\"" + password1+ "" + "\",\"grant_type\":" + "\"" + grantType+"\",\"client_id\":" + "\"" + client_id+ "\",\"client_secret\":" + "\""+ client_secret+"\""+"}";
	      	        System.out.println(requestBody);
					
		// Building request using requestSpecBuilder
		//RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		//builder.setBody(requestBody);
			
		//Setting content type as application/json or application/xml
		//builder.setContentType("application/json;application/x-www-form-urlencoded;charset=UTF-8");
			
		//RequestSpecification requestSpec = builder.build();	

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = RestAssured.given().contentType("application/json;application/x-www-form-urlencoded;charset=UTF-8").body(requestBody).when().post(APIUrl);
		int i=response.getStatusCode();
		System.out.println(i);
		System.out.println(response.body().asString());
		JSONObject JSONResponseBody = new JSONObject(response.body().asString());
		
		//Fetching the desired value of a parameter
		JSONObject obj = (JSONObject) JSONResponseBody.get("data");
			
		String access_token = obj.getString("access_token");
		login_token = access_token;
		System.out.println(access_token);
		String exploreURL = APIUrl+"/"+access_token;	
		
		//Asserting that result of Norway is Oslo
		//Assert.assertEquals(access_token, "{expectedValue}");
		}
	
	@Test
	public void useTokenToAccess() throws JSONException {
		String APIUrl = "https://sgmc-ad-api-uat.mmvpay.com/docs/api-docs.json";

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
	 	Response response = RestAssured.given().contentType("application/json;application/x-www-form-urlencoded;charset=UTF-8").auth().basic("Authorization", "Bearer " + login_token).when().post(APIUrl);
	 	int i=response.getStatusCode();
		System.out.println(i);
	}
}
