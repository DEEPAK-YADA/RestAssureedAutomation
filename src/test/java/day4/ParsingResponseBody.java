package day4;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingResponseBody {

	// 1st Approach
//	@Test
	public void testJsonResponse() {

		given().contentType("ContenType.JSON").when().get("http://localhost:3000/book").then().statusCode(200)
				// .body("x.body[3].title",equalTo("The Lord of the Rings"))
				// .body("body[3].title", equalTo("The Lord of the Rings"))
				.body("book[3].title", equalTo("The Lord of the Rings"));
		// .log().all();
	}

	// 2nd Approach
//	@Test
	public void testJsonResponse2() {
		Response res = given().contentType("Content-Type.JSON").when().get("http://localhost:3000/book");

//		Assert.assertEquals(res.getStatusCode(), 200);

//		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");

//		String bookName=res.jsonPath().get("res.body[0].title").toString();

//		Assert.assertEquals(bookName, "The Lord of the Rings");

//		new JSONObject(res.asString());				 
	}

	// 3rd
//	@Test
	public void jsonObject() {

		Response res = given().contentType("Content-Type.JSON").when().get("http://localhost:3000/book");

		JSONObject jo = new JSONObject(res.asString());

		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {

			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();

			System.out.println(bookTitle);

			boolean status = false;
			if (bookTitle.equalsIgnoreCase("The Lord of the Rings")) {
				status = true;
				break;
			}

			Assert.assertEquals(status, true);
		}

	}

	@Test
	public void totalPriceOfBooks() {
		
		double totalPrice=0;
		Response res = given().contentType("Content-Type.JSON").when().get("http://localhost:3000/book");

		JSONObject jo = new JSONObject(res.asString());
		
		for (int i = 0; i <=jo.getJSONArray("book").length(); i++) {
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalPrice=totalPrice+Double.parseDouble(price);
		}
		
		System.out.println("total price "+totalPrice);
		
		Assert.assertEquals(totalPrice, 53.92);
	}
}
