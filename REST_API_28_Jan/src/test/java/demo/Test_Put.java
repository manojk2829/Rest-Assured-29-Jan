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


public class Test_Put {
		JSONObject request=new JSONObject();
		@BeforeTest
		public void init(){
			baseURI = "https://reqres.in";
		}

		@Test
		public void test_put(){
			request.put("name", "manoj1");
			request.put("job", "IT1");
			System.out.println(request.toJSONString());

			given().header("Content-Type","application/json")
			.contentType(ContentType.JSON)
            .accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.put("/api/users/2")
			.then()
			.statusCode(200).log().all();
		}
}
