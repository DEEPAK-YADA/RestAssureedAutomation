package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializaztionAndDeserialization {

	
	public void convertPOJO2Json() throws JsonProcessingException {
		
		POJO_Class pojo=new POJO_Class();
		pojo.setName("scott");
		pojo.setPhone("123456");
		pojo.setLocation("France");
		String course[]={"C","C++"};
		pojo.setCourses(course);
	
		//convert java object to JSON Object
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println("json Data"+jsonData);
	}
	
	@Test
	public void convertJSON2POJO() throws JsonMappingException, JsonProcessingException {
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}"; 
		
		//convert JSON Object to java object
		
		ObjectMapper mapper=new ObjectMapper();
		POJO_Class pojo=mapper.readValue(jsonData, POJO_Class.class);
		
		System.out.println("Name : "+pojo.getName());
		System.out.println("Location : "+pojo.getLocation());
		System.out.println("Phone : "+pojo.getPhone());
		System.out.println("Courses : "+pojo.getCourses()[0]);
		System.out.println("Courses : "+pojo.getCourses()[1]);
		
	}
}
