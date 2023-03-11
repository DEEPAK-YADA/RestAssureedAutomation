package day5;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

//	@Test
	public void testXMLResponse() {
		given().when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[4].name",equalTo("Ashor"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		
//		.log().all();
	}
//	@Test
	public void testXMLResponse2() {
	
		Response res=given().when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
		String pageno=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno, "1");
	}
	
	@Test
	public void testXMLResponseBody() {
		Response res=given().when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlObj=new XmlPath(res.asString());
		
		List<String> travellers=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		Assert.assertEquals(travellers.size(), 10);
		
		//verify the names in the list
		List<String> travellersnames=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status=false;
		
		for (String traveller : travellersnames) {
			
			System.out.println("traveller :- "+traveller);
			
			if (traveller.equals("karen")) {
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
