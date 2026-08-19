package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateProductTest extends BaseTest {

    @Test
    public void createProduct() {
        String body = "{ \"title\": \"Test Shirt\", \"price\": 25.5, \"category\": \"clothing\" }";
        given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().post("/products")
                .then().statusCode(201).body("id", notNullValue());
    }

}
