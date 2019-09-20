import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateUser {
    String createUrl;
    JsonPath json;
    Object first;
    RequestSpecification request;


    @BeforeClass
    public void BeforeClass() {
        createUrl = "https://reqres.in/api/users";
        request= RestAssured.given();
    }

    @Test
    public void createUserWithUserName() {
        String payload =("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        json= request.body(payload).header("Content-Type", "application/json").post(createUrl).jsonPath();
        Assert.assertNotNull(json.get("id"));


    }
}



