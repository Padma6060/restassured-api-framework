package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ProductTest extends BaseTest {

    @Test
    public void getAllProducts() {
        given()
                .when().get("/products")
                .then().statusCode(200).body("size()", greaterThan(0));
    }

    @Test
    public void getSingleProduct() {
        given()
                .when().get("/products/1")
                .then().statusCode(200)
                .body("id", equalTo(1))
                .body("title", notNullValue());
    }

    @Test
    public void getAllCategories() {
        given()
                .when().get("/products/categories")
                .then().statusCode(200).body("size()", greaterThan(0));
    }

}
