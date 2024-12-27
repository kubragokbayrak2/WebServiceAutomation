package services;

import config.TrelloConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Board;
import models.Card;

import static io.restassured.RestAssured.given;

public class TrelloService {
    
    public TrelloService() {
        RestAssured.baseURI = TrelloConfig.getBaseUrl();
    }
    
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
    
    public Card createCard(String boardId, String name) {
        // First, get the first list id from the board
        String listId = given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .when()
                .get("/boards/" + boardId + "/lists")
                .then()
                .statusCode(200)
                .extract()
                .path("[0].id");
                
        Response response = given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .queryParam("name", name)
                .queryParam("idList", listId)
                .contentType(ContentType.JSON)
                .when()
                .post("/cards")
                .then()
                .statusCode(200)
                .extract().response();
                
        return response.as(Card.class);
    }
    
    public Card updateCard(String cardId, String newName) {
        Response response = given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .queryParam("name", newName)
                .contentType(ContentType.JSON)
                .when()
                .put("/cards/" + cardId)
                .then()
                .statusCode(200)
                .extract().response();
                
        return response.as(Card.class);
    }
    
    public void deleteCard(String cardId) {
        given()
                .queryParam("key", TrelloConfig.getApiKey())
                .queryParam("token", TrelloConfig.getToken())
                .when()
                .delete("/cards/" + cardId)
                .then()
                .statusCode(200);
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
} 