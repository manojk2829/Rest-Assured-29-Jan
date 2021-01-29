package Fake_API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class Get_Fake {

	@BeforeTest
	public void init(){
		baseURI = "http://localhost:3000";
	}

	@Test
	public void test_Print_method(){
		Response res= get("/Users");
		System.out.println(res.asPrettyString());
		System.out.println("************************************");
	}
	
	@Test
	public void test_Get(){
		given().get("/users").then()
		.statusCode(200).body("FirstName", hasItems("Manoj","Manavi")).log().all();  		
	}
}
