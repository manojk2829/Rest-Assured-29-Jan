package demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
//import static io.restassured.matcher.ResponseAwareMatcher.*;

public class Test_Get {
	
	/*@Test
	public void test_get_call(){
		Response res= get("https://storefront-beta.boutiqaat.com/storefront/rest/v1/landingpages/335/blocks");
		//System.out.println("Get Status Code -- > " + res.getStatusCode());
		//System.out.println("Get Time  -- > " + res.getTime());
		//System.out.println(res.getHeader("Content-Type"));
		System.out.println(res.getBody().asPrettyString());
		System.out.println(" ************************************* ");
		//System.out.println(res.asString());
		
		int statusCoede = res.getStatusCode();
		Assert.assertEquals(statusCoede, 200);
		System.out.println("Response Status Code Successfully Matched");
	}*/
	
	@Test
	public void test_get_2(){
		baseURI = "https://storefront-beta.boutiqaat.com";
		//Response res;
		given()
		 .get("/storefront/rest/v1/landingpages/335/blocks")
       .then()
         .statusCode(200)
         .body("data.blocks[1].id", equalTo(2325)).log().all();
	}

}
