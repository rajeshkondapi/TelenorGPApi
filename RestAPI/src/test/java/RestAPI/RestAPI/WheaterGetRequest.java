package RestAPI.RestAPI;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import DatabaseConnections.Dbconn;
import DatabaseConnections.LocalDBVariables;
import static com.jayway.restassured.RestAssured.*; 
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;



public class WheaterGetRequest {

	public LocalDBVariables lvdb = new LocalDBVariables();
	
	// Status code for 200
	@Test
	public void Test_01() {

		Response resp1 = when().get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad");
		 System.out.println("response status is = "+resp1.getStatusCode());
		 System.out.println("Response Result is = "+resp1.asString());
		 //Assert.assertEquals(resp1.getStatusCode(), 200);
		 //resp.
		
	}
	
/*
	
	// Status code for 401
		@Test
		public void Test_02() {

			Response resp2 = when().get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=");
			 System.out.println("response status is = "+resp2.getStatusCode());
			 Assert.assertEquals(resp2.getStatusCode(), 401);
		}

	// use parameters with REST assured
	
	@Test
	public void Test_03() {

		Response resp3 = given().param("q", "city").
				param("appid", "597f83e6b8efa3f4345e909f37f94df8").
				when().get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println("response status is = "+resp3.getStatusCode());
		
		//resp3.getStatusCode();
		Assert.assertEquals(resp3.getStatusCode(), 200);
		if(resp3.getStatusCode() == 200){
			System.out.println("API is working Fine");
		}
		else{
			System.out.println("API Not working");
		}


	} */
	@Test 
	public void BBC () {
	
	Response respbbc = given().param("callingNumber", "7674954007").
								param("callId", "1539579008299997027637117")
								.when().get("https://wash-loadbalancer-1256378585.ap-south-1.elb.amazonaws.com/motech-platform-server/module/api/washacademy/bookmarkWithScore");
			System.out.println("BBC Output"+ respbbc.asString());
	}
	/*
	//Asserting Testcases in Rest Assured api
	@Test
	public void Test_04() {

		given().param("q", "city").
		param("appid", "597f83e6b8efa3f4345e909f37f94df8").
		when().
		get("http://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);

	}
	// using parameter city and getting response in Json
	@Test
	public void Test_05() {

		Response resp5 = given().param("q", "city").
				param("appid", "597f83e6b8efa3f4345e909f37f94df8").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println(resp5.asString());


	} 
	// using Id
	@Test
	public void Test_06(){
		Response resp6 = given().
				parameter("id", "2172797").
				param("appid", "597f83e6b8efa3f4345e909f37f94df8").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(resp6.getStatusCode(), 200);
		
		System.out.println(resp6.asString());

	} 
	//using Zipcode
	@Test
	public void Test_07(){
		Response resp7 = given().
				parameter("zip", "500033,in").
				param("appid", "597f83e6b8efa3f4345e909f37f94df8").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(resp7.getStatusCode(), 200);
		
		System.out.println(resp7.asString());

	}
	
	// API to get Wheather report by id and geography locations
	@Test
	public void Test_08() {
		Response resp = given().
				parameter("callingNumber", "9705070202").				
				parameter("operator", "AT").
				parameter("circle", "UP").
				parameter("callId", "1234567890123456789012345").
				when().
				get("https://wash-loadbalancer-1256378585.ap-south-1.elb.amazonaws.com/motech-platform-server/module/api/washacademy/user?");
				System.out.println(resp.asString());
				
		// callingNumber=9705070202&operator=AT&circle=UP&callId=1234567890123456789012345
		
		/*String reporzip = resp.then().contentType(ContentType.JSON).extract().path("weather[0].description");
		System.out.println("Weather description by zip Code = " +reporzip);
		
		
		String lon = String.valueOf(resp.then().contentType(ContentType.JSON).extract().path("coord.lon"));
		System.out.println("Longtitude is " +lon);
		
		String lat = String.valueOf(
				resp.
				then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat"));
		System.out.println("Latitude is " +lat);
		
		String reportbycoordinates = given().
				parameter("zip", "500033,in").
				parameter("appid", "597f83e6b8efa3f4345e909f37f94df8").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		System.out.println("Weather description by coordinates = "+reportbycoordinates);
				
		Assert.assertEquals(reporzip, reportbycoordinates);
				
		
	}*/
	/*
	@Test    // To get all states
	
	public void allstates() throws Exception {				
		
			RestAssured.baseURI = "http://services.groupkt.com/state/get/IND"; // making request for url		
			
			
			RequestSpecification httpRequest = RestAssured.given();
			
			
			Response response = httpRequest.get("/all");
			
			// Retrieve the body of the Response
			ResponseBody body = response.getBody();			
		 
			List<Map<String, String>> companies = response.jsonPath().getList("RestResponse.result");
			
			Dbconn dbcon = new Dbconn();
			
			for(int i=0; i<companies.size(); i++){
				
		       String xy1 = String.valueOf(companies.get(i).get("id"));		       
		       
		       dbcon.lvdb.setId(Integer.valueOf(xy1));
		       
		       String xy2 = companies.get(i).get("country");
		       
		       dbcon.lvdb.setCountry(xy2);		       
		       
		       String xy3 = companies.get(i).get("name");
		       
		       //System.out.println("name in setting is = "+xy3);
		       
		       dbcon.lvdb.setNam(xy3);
		       
		       String xy4 = companies.get(i).get("abbr");
		       
		       dbcon.lvdb.setAbbr(xy4);
		       
		       String xy5 = companies.get(i).get("area");
		       
		       dbcon.lvdb.setAre(xy5);
		       
		       String xy6 = companies.get(i).get("largest_city");
		       
		       dbcon.lvdb.setLargest_city(xy6);
		       
		       String xy7 = companies.get(i).get("capital");
		        
		       dbcon.lvdb.setCapital(xy7);	       
		       		       
		       dbcon.s();
		       
		       		 
			}
	}
			*/
		}
	


	

/*ArrayList<String> jArray = new ArrayList<String>();


List all_states = response.jsonPath().getList("RestResponse.result");
jArray.addAll(all_states);
System.out.println("sjnbvjsdnj = "+jArray.set(1, "name"));
for(int i=0; i<4; i++){
System.out.println("List Result is =" +all_states.get(i));
}
//String data = body.asString();
//String arrayResult = data.result;

//System.out.println("Json Array = "+body.asString());



//System.out.println(body[0]);
//System.out.println("Result of only id= "+response.body().jsonPath().get("RestResponse.result.id"));

//ArrayList<String> jArray = new ArrayList<String>();

JSONArray arr_result = new JSONArray();




//Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/");






arr_result = response.body().jsonPath().get("RestResponse.result");
System.out.println("Json Result is = "+arr_result);

for (int i=0; i<arr_result.size(); i++)
{

	JSONObject obj_eachValue = (JSONObject)arr_result.get(i);
	
	String event_id = obj_eachValue.get("id").toString();
	
	jArray.add(event_id);
	
	System.out.println("Json Object = "+jArray.toString());
}

System.out.println("Json Object outside the loop = "+jArray.toString());
*/	
	



//String xy1 = response.body().jsonPath().get("RestResponse.result.id").toString();
//jArray.add(xy1);

/*String xy2 = response.body().jsonPath().get("RestResponse.result.country").toString();
//jArray.add(xy2);
String xy3 = response.body().jsonPath().get("RestResponse.result.name").toString();
//jArray.add(xy3);
String xy4 = response.body().jsonPath().get("RestResponse.result.abbr").toString();
//jArray.add(xy4);
String xy5 = response.body().jsonPath().get("RestResponse.result.area").toString();
//jArray.add(xy5);
String xy6 = response.body().jsonPath().get("RestResponse.result.largest_city").toString();
//jArray.add(xy6);
String xy7 = response.body().jsonPath().get("RestResponse.result.capital").toString();
//jArray.add(xy7);
*/			
//System.out.println("Result is =="+jArray.toString());
//System.out.println("Result of index 0 values = "+jArray.clone().toString());
//String arr = "[1,2]";

//this.lvdb.setId(Integer.parseInt(xy1));
