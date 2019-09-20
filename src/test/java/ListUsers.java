import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.IsIterableContaining.hasItems;

public class ListUsers {
    String baseUrl;
    JsonPath json;
    Object first;


    @BeforeClass
    public void BeforeClass(){
        baseUrl="https://reqres.in/api/users?page=2";
        json =RestAssured.get(baseUrl).jsonPath();
         first =json.getList("data").get(0);
    }

    @Test
    public void verifyTheCountOfUsersInPage(){
        Assert.assertEquals(json.getList("data").size(),6);

        System.out.println(first.toString());
    }

    @Test
    public void verifyUsersDetails(){
        Assert.assertEquals(((HashMap) ((HashMap) first)).get("first_name"),"Michael");
        Assert.assertEquals(((HashMap) ((HashMap) first)).get("last_name"),"Lawson");
    }
}

