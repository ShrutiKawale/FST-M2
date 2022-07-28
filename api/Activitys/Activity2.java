package Activity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    final static String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void  testPost() throws IOException {

        //File file = new File("C:\\Users\\0030WR744\\Desktop\\postRequest.json");
        FileInputStream inputJSON = new FileInputStream("C:\\Users\\0030WR744\\Desktop\\postRequest.json");
        String requestBody = new String(inputJSON.readAllBytes());

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(requestBody).when().post(ROOT_URI);

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("9827"));

    }

    @Test(priority=2)
    public void testGet() {
        try {

            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .pathParam("username", "qwertykey") // Pass request body from file
                            .when().get( ROOT_URI+ "/{username}");
            String resBody = response.asPrettyString();
            File file = new File("C:\\Users\\0030WR744\\Desktop\\response");
            // Create JSON file
            file.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(file.getPath());
            writer.write(resBody);
            writer.close();
            // Assertion
            response.then().body("id", equalTo(8927));
            response.then().body("username", equalTo("qwertykey"));
            response.then().body("firstName", equalTo("Justin"));
            response.then().body("lastName", equalTo("Case"));
            response.then().body("email", equalTo("justincase@mail.com"));
            response.then().body("password", equalTo("password123"));
            response.then().body("phone", equalTo("9812763450"));
        } catch (IOException excp) {
            excp.printStackTrace();
        }}
        @Test(priority=3)
        public void testDelete() throws IOException {
            Response response =
                    given().contentType(ContentType.JSON) // Set headers
                            .pathParam("username", "qwertykey") // Add path parameter
                            .when().delete(ROOT_URI + "/{username}"); // Send POST request

            // Assertion
            response.then().body("code", equalTo(200));
            response.then().body("message", equalTo("qwertykey"));
        }


    }

