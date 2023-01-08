package RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import com.github.fge.jsonschema.keyword.validator.helpers.SchemaArrayValidator;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.module.jsv.JsonSchemaValidator;

public class ApiTest {
	
	@Test
	public void Validateresponse()
	{
		RestAssured
	            .given()
	                .baseUri("https://bookstore.toolsqa.com/BookStore/v1/Books/9781449325862")
	        // get the response
	            .when()
	                .get()
	        // validate the body using schema validator
	            .then()
	                .assertThat()
	                .statusCode(200)
	                .body(JsonSchemaValidator.matchesJsonSchema(new File("./schema/sample.json")));
	}

}
