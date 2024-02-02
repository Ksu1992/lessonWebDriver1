package org.alevel.lesson6;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @Test
    public void testEmojisEndpoint() {
        // Ваш URL
        String url = "https://api.github.com/emojis";

        // Налаштування RestAssured
        RestAssured.baseURI = url;

        // Запит та перевірка
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .body(containsString("articulated_lorry"));
    }
}
