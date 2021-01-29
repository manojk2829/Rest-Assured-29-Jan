package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.response.Response.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Test_Post {
	JSONObject request=new JSONObject();
	@BeforeTest
	public void init(){
		baseURI = "https://reqres.in";
	}

	/*@Test
     public void test(){
    	 Response res= get("https://reqres.in/api/users?page=2");
    	 System.out.println(res.getStatusCode());
    	 System.out.println(res.getBody().asPrettyString());
     }

	@Test
     public void test_get(){
          given()
          .get("/api/users?page=2")
          .then().body("data[5].first_name", equalTo("Rachel"))
          .body("data.first_name", hasItems("Michael","Rachel")).log().all();
     }*/

	@Test
	public void test_Post(){
		Map<String, Object> map=new HashMap<String, Object>();
		request.put("name", "manoj1");
		request.put("job", "IT1");
		//request.put("sal", 10000);

		System.out.println(request.toJSONString());
		given()
		.body(request.toJSONString())
		.when()
		.post("/api/users")
		.then()
		.statusCode(201).log().all();
	}
}