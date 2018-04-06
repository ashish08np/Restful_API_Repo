import org.apache.commons.codec.binary.Base64;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Jersey {

	public static void main(String[] args) {
//		JerseyGet();
//		//JerseyPost();
//
	}
	
	public static void JerseyGet(){
		String url = "https://beta-ih-flexm.mmvpay.com/api/v1/users";
        String name = "flexm-frontend";
        String password = "N2MxYmRkNTA5MmEwYjQzZWFjNTI5ZTRiNDc0YzA1OGNhZDJlNGU5OTUwMWI2NGE1OWQ3M2Y3MTY1YWUxNDIzMA";
        String authString = name+":"+password;
        String authString1 = new String(Base64.encodeBase64(authString.getBytes()));
        String authStringEnc = new String(authString1);
        String acesstoken = "d41f9a10e3e74f3972bd903fa361fa421e5dfd01";
       // String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        Client restClient = Client.create();
        WebResource webResource = restClient.resource(url);
        ClientResponse resp = webResource.accept("application/json").header("Authorization", "Bearer " + acesstoken).get(ClientResponse.class);;
        if(resp.getStatus() != 200){
            System.err.println("Unable to connect to the server");
        }
        String output = resp.getEntity(String.class);
        System.out.println("response: "+output);
	}
	
	public static void JerseyPost(){
		String url = "https://beta-ih-flexm.mmvpay.com/api/v1/users";
        String name = "flexm-frontend";
        String password = "N2MxYmRkNTA5MmEwYjQzZWFjNTI5ZTRiNDc0YzA1OGNhZDJlNGU5OTUwMWI2NGE1OWQ3M2Y3MTY1YWUxNDIzMA";
        String authString = name+":"+password;
        String authString1 = new String(Base64.encodeBase64(authString.getBytes()));
        String authStringEnc = new String(authString1);
       // String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
        System.out.println("Base64 encoded auth string: " + authStringEnc);
        
      //Initializing Request API Body
        String email="ashish.nayak4321@qualitest.in";
        String password1="Password@123";
        String first_name="Ashishtester";
        String last_name="Qualitestmover";
        String preferred_name="Qualiwedgwd";
        String mobile_country_code="91";
        String mobile="9834234321";
        String grant_type="client_credentials";
        String device_signature="front-end";
        
        String requestBody = "{\"email\":" + "\"" + email
        + "" + "\",\"password\":" + "\"" + password1
        + "" + "\",\"first_name\":" + "\"" + first_name
        +"\",\"last_name\":" + "\""+last_name
        +"\",\"preferred_name\":" + "\""+ preferred_name
        +"\",\"mobile_country_code\":" + "\""+ mobile_country_code
        +"\",\"mobile\":" + "\""+ mobile
        +"\",\"grant_type\":" + "\""+ grant_type
        +"\",\"device_signature\":" + "\""+ device_signature+"\""
        +"}";
	    System.out.println(requestBody);
	    
//	    // Building request using requestSpecBuilder
//	 	RequestSpecBuilder builder = new RequestSpecBuilder();
//	 			
//	 	//Setting API's body
//	 	builder.setBody(requestBody);
//	 	//Setting content type as application/json or application/xml
//	 	builder.setContentType("application/json");
//	 	
//	 	RequestSpecification requestSpec = builder.build();
//	 	requestSpec.auth().basic(name, password);
//	 	Response res = requestSpec.post(url);
//	 	System.out.println(res.getStatusCode());
//	 	System.out.println(res.getStatusLine());
//	 	System.out.println(res.asString());
//	 	
	 	
	 	//Making post request with authentication, leave blank in case there are no credentials- basic("","")
	 	Response response = RestAssured.given().contentType("application/json;charset=UTF-8").auth().basic("Authorization", "Basic " + authStringEnc).body(requestBody).when().post(url);
	    
	 	if(response.getStatusCode() != 200){
          System.err.println("Unable to connect to the server"+response.getStatusCode());
	 	}else{
	 		System.out.println("The status code :"+response.getStatusCode());
	 	}
	 	String output = response.asString();
	 	System.out.println("response: "+output);
	 		
//        Client restClient = Client.create();
//        WebResource webResource = restClient.resource(url);
//        ClientResponse resp = webResource.type("application/json").header("Authorization", "Basic " + authStringEnc).post(ClientResponse.class,requestBody);
//   	 	 if(resp.getStatus() != 200){
//            System.err.println("Unable to connect to the server");
//        }
//        String output = resp.getEntity(String.class);
//        System.out.println("response: "+output);
	}

}
