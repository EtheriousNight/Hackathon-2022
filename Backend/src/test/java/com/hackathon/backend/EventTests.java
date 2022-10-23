package com.hackathon.backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class EventTests {

    private final String STREET_NAME = "Schlesische Straße";
    private final String CITY_DISTRICT = "Königshufen";
    private final String CITY = "Görlitz";
    private final String COUNTY = "Landkreis Görlitz";

    @BeforeAll
    public static void init() {
        RestAssured.port = 8080;
    }

    private Integer createLocation() throws ParseException {
        var body = new JSONObject();
        body.put("street", STREET_NAME);
        body.put("cityDistrict", CITY_DISTRICT);
        body.put("city", CITY);
        body.put("county", COUNTY);

        var postResponse = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("api/v1/location/create");

        var rawContent = postResponse.body().asString();
        var jsonBody = (JSONObject) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(rawContent);

        var id = (Integer) jsonBody.get("id");
        System.err.println("Location ID: " + id);
        return id;

    }

    private Integer createEvent(Integer locationId) throws ParseException {
        var body = new JSONObject();
        body.put("name", "Test Event");
        body.put("start", Timestamp.from(Instant.now()).toString());
        body.put("ending", Timestamp.from(Instant.now()).toString());
        body.put("location", null);

        var response = RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("api/v1/event/create/" + locationId);

        var rawContent = response.body().asString();
        var jsonBody = (JSONObject) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(rawContent);

        var id = (Integer) jsonBody.get("id");
        return id;
    }

    @Test
    void getEventById() throws ParseException {
        var newLocationId = createLocation();
        var newEventId = createEvent(newLocationId);
        var getPath = "api/v1/event/get/" + newEventId.toString();
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);

        var getContent = (JSONObject) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());
        System.err.println(getContent.toJSONString());
        var getId = (Integer) getContent.get("id");

        System.err.println(
                "Name: " + getContent.get("name") + "\n" +
                "Start: " + getContent.get("start") + "\n" +
                "Ending: " + getContent.get("ending") + "\n" +
                "Location" + getContent.get("location")
        );

        Assertions.assertEquals(newEventId, getId);

    }

    @Test
    void getEventsByStreet() throws ParseException {

        var locationId = createLocation();
        createEvent(locationId);
        createEvent(locationId);
        createEvent(locationId);

        var getPath = "api/v1/event/get/street/" + STREET_NAME;
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);
        var getContent = (JSONArray) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());

        System.err.println(getContent.toJSONString());
        Assertions.assertEquals(3, getContent.size());

    }

    @Test
    void getEventsByCityDistrict() throws ParseException {

        var locationId = createLocation();
        createEvent(locationId);
        createEvent(locationId);
        createEvent(locationId);

        var getPath = "api/v1/event/get/district/" + CITY_DISTRICT;
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);
        var getContent = (JSONArray) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());

        System.err.println(getContent.toJSONString());
        Assertions.assertEquals(3, getContent.size());

    }

    @Test
    void getEventsByCity() throws ParseException {

        var locationId = createLocation();
        createEvent(locationId);
        createEvent(locationId);
        createEvent(locationId);

        var getPath = "api/v1/event/get/city/" + CITY;
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);
        var getContent = (JSONArray) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());

        System.err.println(getContent.toJSONString());
        Assertions.assertEquals(3, getContent.size());

    }

    @Test
    void getEventsByCounty() throws ParseException {

        var locationId = createLocation();
        createEvent(locationId);
        createEvent(locationId);
        createEvent(locationId);

        var getPath = "api/v1/event/get/county/" + COUNTY;
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);
        var getContent = (JSONArray) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());

        System.err.println(getContent.toJSONString());
        Assertions.assertEquals(3, getContent.size());

    }

    @Test
    void createdDataTest() throws ParseException {

        var address = "Schlesische Straße";
        var getPath = "api/v1/event/get/city/" + address;
        var getResponse = RestAssured.given()
                .when()
                .get(getPath);

        getResponse.then().statusCode(200);
        var getContent = (JSONArray) new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE).parse(getResponse.body().asString());

        System.err.println(getContent.toJSONString());

    }

}
