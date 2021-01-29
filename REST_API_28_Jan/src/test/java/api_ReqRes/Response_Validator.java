package api_ReqRes;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Response_Validator {
	
	@BeforeTest
	public void test_init(){
		baseURI = "https://reqres.in";
	}
	
	@Test
	public void test_get_response_Validator(){
		given().get("api/users?page=2").then().assertThat()
		.body(matchesJsonSchemaInClasspath("Schema_File.json")).statusCode(200).log().all();
	}

}
