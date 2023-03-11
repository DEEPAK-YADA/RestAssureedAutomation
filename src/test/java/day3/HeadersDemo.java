package day3;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class HeadersDemo {


	public void testHeaders() {
	given()
	
	.when()
			.get("https://www.google.com/")
	.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws");
	}
	

	public void captureSingleUsers() {
	Response res=given().when().get("https://www.google.com/");
	System.out.println(res.header("Server"));
	}
	
	@Test
	public void getSingleUserHeaders() {
		//  1st approach  (print specific headers)
		
//	Response res=given().when().get("https://www.google.com/");
//	Headers myHeaders=res.getHeaders();
//	
//	for(Header header:myHeaders) {
//		System.out.println(header.getName()+"======  "+header.getValue());
//	}
	
		//  2nd approach   (print with all the info of the headers)
		
//		given().when().get("https://www.google.com/").then().log().all();
	
		
		//  3rd approach   (print specific headers)	  //only Headers print	
//		given().when().get("https://www.google.com/").then().log().headers();
		
	//    (print specific body)	  
			given().when().get("https://www.google.com/").then().log().body();
	}
}
