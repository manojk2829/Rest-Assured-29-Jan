package Fake_API;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Post_API {
	@BeforeTest
	public void init_test(){
		baseURI = "http://localhost:3000/";
	}
	@Test
	public void test_Post(){
		Response res = get("/Users");
		JSONObject response = new JSONObject();
		response.put("FirstName","Vijay");
		response.put("LastName", "Kumar");
		response.put("Subject", "Computer");
		
		given().header("Content-Type","application/json")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(response.toJSONString())
		.when().post("/Users")
		.then().statusCode(201)
		.body("FirstName", equalTo("Vijay"))
		.body("LastName", equalTo("Kumar"))
		.log().all();		
		System.out.println(res.asPrettyString());
	}
}
