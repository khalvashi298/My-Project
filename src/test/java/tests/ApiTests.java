//package tests;
//import io.restassured.RestAssured;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//public class ApiTests {
//
//    @Test
//    public void testStatusCode() {
//        int statusCode = RestAssured.get("https://reqres.in/api/users?page=2").getStatusCode();
//        Assert.assertEquals(statusCode, 200, "Status code is not 200");
//    }
//
//}
package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @Test
    public void testStatusCodeAndResponseBody() {
        // RestAssured API ტესტი
        RestAssured.baseURI = "https://reqres.in";

        given()
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200) // ელოდება სტატუს კოდს 200
                .body("page", equalTo(2)) // ამოწმებს, რომ გვერდი არის 2
                .body("data.size()", equalTo(6)); // ამოწმებს, რომ მონაცემებში არის 6 ობიექტი
    }
}
