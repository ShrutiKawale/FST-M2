package Activity;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class ProjectRestAssured {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpecificationSpec;
    String sshKey;
    int keyID;

    @BeforeClass
    public void setup(){
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","token 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")
                .setBaseUri("https://api.github.com")
                .build();

    }
    @Test(priority=1)
    public void addKey() throws IOException {

        FileInputStream inputJSON = new FileInputStream("C:\\Users\\0030WR744\\Desktop\\postRequestKey.json");
        String reqBody = new String(inputJSON.readAllBytes());
        //System.out.println(reqBody);
        Response
        response= given().spec(requestSpec)
                .body(reqBody)
                .when().post("/user/keys");

        System.out.println(response.prettyPrint());

    }
    @Test(priority=2)
    public void getKeys() {
        Response
                response= given().spec(requestSpec)
                .when().get("/user/keys");

            System.out.println(response.asPrettyString());
           keyID= response.then().extract().path("[1].id");
           System.out.println(keyID);
    }

    @Test(priority=3)
    public void deleteKey() {
        Response
                response= given().spec(requestSpec)
                .when().pathParam("keyID", keyID).delete("/user/keys/{keyID}");

        System.out.println(response.asPrettyString());
    }
}
