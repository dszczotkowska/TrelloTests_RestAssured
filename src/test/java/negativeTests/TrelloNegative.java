package negativeTests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TrelloNegative extends BaseTest {
    @Test
    public void createOrgWithoutDisplayName() {
        given()
                .spec(reqspec)
                .queryParam("displayName", "")
                .when()
                .post(BASE_URL + ORGANIZATION)
                .then()
                .statusCode(400);
    }

    @Test
    public void createBoardWithIntInName() {
        given()
                .spec(reqspec)
                .queryParam("name", 1)
                .when()
                .post(BASE_URL + BOARDS)
                .then()
                .statusCode(400);
    }
}
