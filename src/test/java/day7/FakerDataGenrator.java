package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenrator {

	@Test
	public void testGenrateData() {
		
		Faker faker=new Faker();
		String fullName=faker.name().fullName();
		
		String fName=faker.name().firstName();
		String lName=faker.name().lastName();
		
		String uname=faker.name().username();
		String pwd=faker.internet().password();
		
		String phoneNum=faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		
		System.out.println("Full Name :"+fullName);
		System.out.println("First Name :"+fName);
		System.out.println("Last Name :"+lName);
		System.out.println("User Name :"+uname);
		System.out.println("Password Name :"+pwd);
		System.out.println("Phone Number :"+phoneNum);
		System.out.println("Email Name :"+email);
		
	}
}
