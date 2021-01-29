package Fake_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Delete_API {
	@BeforeTest
	public void init_test(){
		baseURI = "http://localhost:3000/";
	}
	@Test
	public void test_delete(){
		Response res = get("/Users");
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.when().delete("/Users/1")
		.then().statusCode(200)
		.log().all();
		
		System.out.println(res.asPrettyString());
	}
}

