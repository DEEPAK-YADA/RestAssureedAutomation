package day7;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Authorization {

	
	//-----    Basic Auth
	//@Test
	public void testBasicAuthentication() {
		
	given()
			.auth().basic("postman", "password")
	.when()
			.get("https://postman-echo.com/basic-auth")
	.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}

/*   Digest Auth	*/
//	@Test
	public void testDigestAuthentication() {
		
	given()
			.auth().digest("postman", "password")
	.when()
			.get("https://postman-echo.com/basic-auth")
	.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}
	
/*  Preemptive  Auth*/	
//	@Test
	public void testPreemptiveAuthentication() {
		
	given()
			.auth().preemptive().basic("postman", "password")
	.when()
			.get("https://postman-echo.com/basic-auth")
	.then()
			.statusCode(200)
			.body("authenticated",equalTo(true));
	}
	
	
	/*  Bearer  Token*/	
//	@Test
	public void testBearerAuthentication() {
		
		String bearerToken="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";
	
		given()
			.headers("Authorization","Bearer "+bearerToken)
	.when()
			.get("https://api.github.com/user/repos")
	.then()
			.statusCode(200)
			.log().all();
	}
	
	/*  Bearer  Token*/	
	@Test
	public void testOAuth2() {
		
		String bearerToken="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";
	
		given()
			.auth().oauth2(bearerToken)
	.when()
			.get("https://api.github.com/user/repos")
	.then()
			.statusCode(200)
			.log().all();
	}
}


