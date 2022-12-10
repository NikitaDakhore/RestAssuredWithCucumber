package stepdef;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDPostStepDef {

	Response response;
	RequestSpecification request;
	Map<String,Object> MapObj;
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
	    
		request = RestAssured.given().baseUri(URI);
	}
	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		
		response = request.get();

	}
	
	
	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
	   
		Assert.assertEquals(expResponseCode, response.getStatusCode());
	}
   
	@When("I perform the Post oeration where name is (string) and salary is (string)")
	public void i_perform_the_Get_Operation_where_name_is_and_salary_is(String name, String sal) {
		 // Write code here that turns the phrase above into concrete actions
		MapObj = new HashMap<String,Object>();
		
		MapObj.put("name",name);
		MapObj.put("salary",sal);
		
		response = request.contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(MapObj).post("create");
	}
}
