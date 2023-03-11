package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DiffWaysToCreatePostRequestBody {

	//using post Hash Map 
	//@Test
	public void testPostUsingHashMap() {
	
		HashMap data=new HashMap();
		data.put("name", "scott");
		data.put("location", "France");
		data.put("phone", "123455667788");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
				.contentType("application/json")
				.body(data)
		.when()
				.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123455667788"))
		.body("courses[0]", equalTo("C"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	
	//deleting student record
	//@Test(priority = 1)
	public void testDelete() {
		given()
		
		.when()
				.delete("http://localhost:3000/students/11")
		.then().statusCode(200).log().all();
	}
	
//	@Test(priority = 1)
	public void testPostByUsingJsonLib() {
		
		JSONObject data=new JSONObject();
		
		data.put("name", "scott");
		data.put("location", "France");
		data.put("phone", "123455667788");
		
		String courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
				.contentType("application/json")
				.body(data.toString())
		.when()
				.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123455667788"))
		.body("courses[0]", equalTo("C"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	
	//deleting student record
	//@Test(priority = 2)
	public void testDeleteByUsingJsonLib() {
		given()
		
		.when()
				.delete("http://localhost:3000/students/11")
		.then().statusCode(200).log().all();
	}
	
	// By Using POJO class
	//@Test(priority = 1)
	public void testPostByUsingPOJO() {
		
		POJO_PostRequest data=new POJO_PostRequest();
		data.setName("scott");
		data.setLocation("France");
		data.setPhone("123455667788");

		
		String courseArr[]= {"C","C++"};
		data.setCourses(courseArr);
		
		given()
				.contentType("application/json")
				.body(data)
		.when()
				.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name", equalTo("scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123455667788"))
		.body("courses[0]", equalTo("C"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}

	//@Test(priority = 2)
	public void testDeleteByUsingPOJOClass() {
		given()
		
		.when()
				.delete("http://localhost:3000/students/11")
		.then().statusCode(200).log().all();
	}
	
	
	
	//By Using External Json File	
		@Test(priority = 1)
		public void testPostByUsingExternalJSONFile() throws FileNotFoundException {
			
			FileReader f=new FileReader(new File(".\\body.json"));
			
			JSONTokener jt=new JSONTokener(f);
			JSONObject data=new JSONObject(jt);
			
			given()
					.contentType("application/json")
					.body(data.toString())
			.when()
					.post("http://localhost:3000/students")
			.then()
			.statusCode(201)
			.body("name", equalTo("scott"))
			.body("location", equalTo("France"))
			.body("phone", equalTo("1234432324"))
			.body("courses[0]", equalTo("C"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}

	//	@Test(priority = 2)
		public void testDeleteByUsingExternalJSONFile() {
			given()
			
			.when()
					.delete("http://localhost:3000/students/11")
			.then().statusCode(200).log().all();
		}

}
