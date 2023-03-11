package day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class XmlSchemaValidation {

	@Test
	public void xmlSchemaValidation() {
		
		given()
		
		.when()
				.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveller.xsd"));
	}
}
