package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Board;
import static io.restassured.RestAssured.given;
import config.TrelloConfig;

public class BoardPage {
    
    public Board createBoard(String name) {
        Response response = given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .queryParam("name", name)
                .contentType(ContentType.JSON)
                .when()
                .post("/boards")
                .then()
                .statusCode(200)
                .extract().response();
                
        return response.as(Board.class);
    }
    
    public void deleteBoard(String boardId) {
        given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .when()
                .delete("/boards/" + boardId)
                .then()
                .statusCode(200);
    }
    
    public String getFirstListId(String boardId) {
        return given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .when()
                .get("/boards/" + boardId + "/lists")
                .then()
                .statusCode(200)
                .extract()
                .path("[0].id");
    }
} 