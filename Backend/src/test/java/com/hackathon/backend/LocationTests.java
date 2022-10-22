package com.hackathon.backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class LocationTests {

    @BeforeAll
    public static void init() {
        RestAssured.port = 8080;
    }

    private Integer createLocation() throws ParseException {

        var body = new JSONObject();
        body.put("street", "Am Affen");
        body.put("cityDistrict", "Vorstadt");
        body.put("city", "Affenstadt");
        body.put("county", "Oberlausitz");

        var response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("api/v1/location/create");

        var rawContent = response.body().asString();
        var jsonBody = (JSONObject) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(rawContent);
        System.out.println(jsonBody.toString());

        var id = (Integer) jsonBody.get("id");
        return id;

    }

    @Test
    void getLocationById() throws ParseException {
        var newLocationId = createLocation();
        System.out.println(newLocationId);
    }

}
