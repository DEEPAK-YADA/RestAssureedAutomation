package day3;

import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesDemo {

	
	public void testCookies() {
		
		given()
		
		.when()
				.get("https://www.google.com/")
		.then()
				.cookie("AEC","ARSKqsLQj9m03PYPdW-I72Fu3WPCXQv0ICBI1Nk--zL6GrywfT5rXvKoIMI")
				.log().all();
	}
	
	
	public void getCookiesInfo() {
		
		Response response=given().when().get("https://www.google.com/");
		String cookie_value=response.getCookie("AEC");
		
		System.out.println("value of the cookies is ==>"+cookie_value);
		
	}
	
	@Test
	public void getAllCookiesInfo() {
		
		Response response=given().when().get("https://www.google.com/");
		Map<String, String> cookies_value=response.getCookies();
		
		System.out.println("value of the cookies is ==>"+cookies_value);
		
		for(String cookie:cookies_value.keySet()) {
		String cookies_val=	response.getCookie(cookie);
		
		System.out.println(cookie+"  ======  "+cookies_val);
		}
		
	}
}
