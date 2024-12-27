package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Card;
import static io.restassured.RestAssured.given;
import config.TrelloConfig;

public class CardPage {
    
    public Card createCard(String listId, String name) {
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
} 