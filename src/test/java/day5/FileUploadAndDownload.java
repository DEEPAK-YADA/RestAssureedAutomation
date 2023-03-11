package day5;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FileUploadAndDownload {

	@Test
	public void singleFileUpload() {
		
		File myFile=new File("C:\\Users\\HP\\Documents\\Sample.txt");
		
		given()
				.multiPart("file",myFile)
				.contentType("multipart/form-data")
		.when()
				.post("https://the-internet.herokuapp.com/upload")
		.then()
		.statusCode(200)
		.body("fileName", equalTo("Sample.txt"))
		.log().all();
	}
}
