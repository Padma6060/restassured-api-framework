package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UpdateDeleteTest extends BaseTest {

    @Test
    public void updateProduct() {
        String body = "{ \"title\": \"Updated Shirt\", \"price\": 30 }";
        given()
                .header("Content-Type", "application/json")
                .body(body)
                .when().put("/products/1")
                .then().statusCode(200);
    }

    @Test
    public void deleteProduct() {
        given()
                .when().delete("/products/1")
                .then().statusCode(200);
    }
}
