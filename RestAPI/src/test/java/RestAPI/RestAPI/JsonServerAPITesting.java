package RestAPI.RestAPI;

import org.json.JSONObject;
import org.testng.annotations.Test;

import APITesting.com.org.classes.Posts;
import APITesting.com.org.classes.advancedExample._Info;
import APITesting.com.org.classes.advancedExample.__Posts;

import com.google.gson.JsonObject;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*; // if static no need create object


public class JsonServerAPITesting {
	
	
	
	/*Posts posts = new Posts();   // creating object for post class to implement in body.
	
	@Test // given when i want to send a GET uri , by this ill get response in resp.
	public void Test_01(){
		Response resp1= given().
						when().
						get("http://localhost:3000/posts"); // we send url to retreive data.
		System.out.println("Get Response is : " +resp1.asString());
	}
	
	  //POST   /posts
	@Test  // given whose body in the form of string when content type is Json-Server
	public void Test_02(){
		Response resp2 = given().
						body("{\"id\":\"2\","
								+ "\"title\":\"dummyTitle\","
								+ "\"author\":\"Rajesh\" } ").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:3000/posts");
		System.out.println("Post updated : " +resp2.asString());
		// once we posted other data this will updated in db.json, this can be checked using get response
	}
	 
	@Test   // sending data in form of objects using body
	public void Test_03(){
		
		
		posts.setId("3");
		posts.setAuthor("kondapi");
		posts.setTitle("posts request by object");
		
		Response resp3 = given().
						when().
						contentType(ContentType.JSON).
						body(posts).
						post("http://localhost:3000/posts");
		System.out.println("Post updated : " +resp3.asString());
		
	}
	
	@Test 
	public void Test_dummy() {
		posts.setId("3");
		posts.setBody("dummy body 3");
		posts.setPostId("3");
		
		Response resp_dum = given().
				when().contentType(ContentType.JSON).body(posts).post("http://localhost:3000/rajesh/2");
		System.out.println("rajesh field Updated: "+ resp_dum.asString());
		
	}
	
	@Test   
	public void Test_04(){
		
		
		Response resp4 = given().
						when().
						contentType(ContentType.JSON).						
						get("http://localhost:3000/posts/2");
		System.out.println("get required data by id : " +resp4.asString());
		
	} 
	@Test  // update the entries using put method
	public void Test_05() {
		Posts posts = new Posts();
		posts.setId("3");
		posts.setTitle("updated title name");
		posts.setAuthor("updated author name");
		
		Response resp5 = given().
						when().
						contentType(ContentType.JSON).
						body(posts).
						put("http://localhost:3000/posts/3"); 
		System.out.println("change data for required is:" +resp5.asString());
		
	} 
	
	@Test  // Patch Method - updates only one selected data 
	public void Test_06(){
		
		Response resp6 = given().
						body("{\"title\":\"updated title by patch request xml\"}").						
						contentType(ContentType.JSON).
						patch("http://localhost:3000/posts/3");
						
		
		System.out.println("patch request to update title only :" +resp6.asString());
		
		
	}
	
	@Test  // delete Method - delete the data
	public void Test_07(){
		
		Response resp7 = given().						
						when().
						contentType(ContentType.JSON).
						delete("http://localhost:3000/posts/2");						
		
		System.out.println("delete request  :" +resp7.asString());
		
	} 
	
	@Test  // Json object test case using array data inside another data
	public void test_08(){
		info info = new info();
		info.setEmail("kondapirajesh@gmail.com");
		info.setAddress("info@seleniumapi.com");
		info.setPhone("India, Hyderabad");
		
		_Posts posts = new _Posts();
		posts.setAuthor("Author");
		posts.setId("10");
		posts.setTitle("title");
		posts.setInfo(info);
		
		Response resp8 = given().
		when().
		contentType(ContentType.JSON).
		body(posts).
		post("http://localhost:3000/posts");
		
		System.out.println("Response: "+ resp8.asString());
		
	} 
	
	@Test 
	public void Test_09(){
		_Info info1 = new _Info();
		info1.setAddress("info 1 address");
		info1.setEmail("info1email@seleniumapi.com");
		info1.setPhone("1111111");
		
		_Info info2 = new _Info();
		info2.setAddress("info 2 address");
		info2.setEmail("info2@seleniumapi.com");
		info2.setPhone("2222222");
		
		__Posts posts = new __Posts();
		posts.setAuthor("advanceAuthor");
		posts.setId("advanced id");
		posts.setTitle("advanced title");
		posts.setInfo(new _Info[]{info1, info2});
		
		Response resp9 = given().when().	contentType(ContentType.JSON).body(posts).post("http://localhost:3000/posts");	
		System.out.println("Json Array objects"+resp9.asString());	
		
		
	} 
	
	@Test  //Get Request calculate response time
	public void Test_10(){
		Response resp10 = given().
		when().
		get("http://localhost:3000/posts");
		
		Long time = resp10.
		then().
		extract().
		time();
		
		System.out.println("Response time taken is: "+time);
		
				given().
				when().
				get("http://localhost:3000/posts").
				then().
				and().
				time(lessThan(700L));
		
		
		
	}
	
	
*/	
	
	
	
}
