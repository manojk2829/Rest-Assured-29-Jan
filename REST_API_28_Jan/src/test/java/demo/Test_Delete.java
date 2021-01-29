package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.response.Response.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test_Delete {
		@BeforeTest
		public void init(){
			baseURI = "https://reqres.in";
		}

		@Test
		public void test_delete(){
			given().header("Content-Type","application/json")
			.contentType(ContentType.JSON)
            .accept(ContentType.JSON)
			.delete("/api/users/2")
			.then()
			.statusCode(204).log().all();
		}
}
