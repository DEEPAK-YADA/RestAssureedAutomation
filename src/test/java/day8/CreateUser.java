package day8;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {

	@Test
	public void testCreateUser() {
		
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="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";
		
		int id=given()
				.headers("Authorization","Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
		.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
		
		System.out.println("Genrated id is:"+id);
		
	}
}
