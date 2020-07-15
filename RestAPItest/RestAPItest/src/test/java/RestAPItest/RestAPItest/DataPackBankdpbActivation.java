package RestAPItest.RestAPItest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import apiMethods.Bodyclass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataPackBankdpbActivation 

{
  @Test
  public void f() throws Exception 
  {
	  
/* *************************************************GET method************************************************************** */	  
//	  // Specify the base URL to the RESTful web service
//	  RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//	  
//	  // Get the RequestSpecification of the request that you want to sent
//	  // to the server. The server is specified by the BaseURI that we have
//	  // specified in the above step.
//	  RequestSpecification httpRequest = RestAssured.given();
//	  
//	  // Make a request to the server by specifying the method Type and the method URL.
//	  // This will return the Response from the server. Store the response in a variable.
//	  Response response = httpRequest.request(Method.GET, "/Hyderabad");
//	  
//	  // Now let us print the body of the message to see what response
//	  // we have recieved from the server
//	  String responseBody = response.getBody().asString();
//	  System.out.println("Response Body is =>  " + responseBody);
//	  
//	  int statuscode = response.getStatusCode();
//	  System.out.println("Status ccode is =>" + statuscode);
//	  
////	  Assert.assertEquals(statuscode, 200,"correct status code returned");
//	  JsonPath jsonPathEvaluator = response.jsonPath();
//	  String city = jsonPathEvaluator.get("City");
//	  
//	  Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
//	  
//	  
//	  String serverType =  response.header("Server");
//	  System.out.println("serverType =>" + serverType);
//	 
////	  Assert.assertEquals(serverType /* actual value */, "nginx/1.12.1" /* expected value */);
	  

/* *************************************************POST method************************************************************** */		  
	  		
//	  RestAssured.baseURI ="http://restapi.demoqa.com/customer";
//	  RequestSpecification request = RestAssured.given();
//	  
//	  JSONObject requestParams = new JSONObject();
//	  requestParams.put("FirstName", "Virender"); // Cast
//	  requestParams.put("LastName", "Singh");
//	  requestParams.put("UserName", "sdimpleuser2dd2011");
//	  requestParams.put("Password", "password1");
//	  
//	  requestParams.put("Email",  "sample2ee26d9@gmail.com");
//	  request.body(requestParams.toString());
//	  Response response = request.post("/register");
//	  
//	  int statusCode = response.getStatusCode();
//	  System.out.println("statusCode =>" + statusCode);
////	  Assert.assertEquals(statusCode, "201");
////	  String successCode = response.jsonPath().get("SuccessCode");
////	  Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//	  String responsebody = response.getBody().asString();
//	  
//	  System.out.println("Response body =>" + responsebody);
	
/* *************************************************POST method of IMI************************************************************** */
	  
	  Bodyclass bc = new Bodyclass();
	  bc.setTransid("20181224103021455");
	  bc.setMsisdn("OTU5OTU2OTQ1MjI1");
	  bc.setVendorid("1001");
	  bc.setChn("web");
	  bc.setOfferid("117440");
	  bc.setRemarks("round");
	  
	  RestAssured.baseURI ="http://ecarepreprod.ooredoo.com.mm/DataPackActBank/api";
	  
	  Response httpRequest = RestAssured.given()
	  .headers("X-IMI-REQINIT", "201815110327121")
	  .headers("X-IMI-SIGNATURE", "C726E47DE73D8258D03723CEFBE7631F86E0AE466E5A7F64DB35A7FE579443B2D3AC3CD4F0290FFDC15D7574F4FD7FEEF2EFFEBCAD31BFDF1B2BF9485C4483E9")
	  .headers("X-FORWARDIP", "127.0.0.1")
	  .headers("Authorization", "Basic aW1pdGVzdDppbWl0ZXN0MTIz")
	  .when()
	  .contentType(ContentType.JSON)
	  .body(bc).post("/dpbActivation");
	
	  System.out.println(httpRequest.asString());
	  
  }

}
