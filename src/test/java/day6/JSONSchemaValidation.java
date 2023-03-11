package day6;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	//@Test
	public void jsonSchemaValidation() {
		
		given()
		
		.when()
				.get("http://localhost:3000/book")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookJsonSchema.json"));
	}
}
