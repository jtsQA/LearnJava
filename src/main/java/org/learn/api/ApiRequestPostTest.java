package org.learn.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.learn.concepts.EncodeDecode;
import org.utils.FilesHandler;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiRequestPostTest {

    @Test
    public void testPostRequest() {
        // Define base URI and path
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        String path = "/users";

        User user = new User("adam joan", "male", "adam.joan4@email.com", "active");

        String token = EncodeDecode.decodeData(FilesHandler.getConfigValue("token"));

        // Perform POST request and capture the response
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(user.toString())
                .when()
                .post(path)
                .then()
                .assertThat()

                // Validate response code
                .statusCode(201)

                // Validate response time
                .time(lessThan(9000L))

                // Validate response size
                .body("", not(empty()))

                // Validate response body
                .body("id", notNullValue())
                .body("name", equalTo(user.name()))
                .body("gender", equalTo(user.gender()))
                .body("email", equalTo(user.email()))
                .body("status", equalTo(user.status()))

                // Validate response headers
                .header("Content-Type", containsString("application/json"))

                // Validate response against schema
//                .body(matchesJsonSchemaInClasspath(System.getProperty("user.dir") + "src/main/java/org/schemas/response-schema-new-user.json"))
                .extract().response();

        // Get response body as a string
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Get specific headers from the response
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type: " + contentType);
    }

}

record User(String name, String gender, String email, String status) {

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing User object to JSON", e);
        }
    }
}