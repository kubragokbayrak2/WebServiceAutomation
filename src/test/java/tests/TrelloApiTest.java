package tests;

import config.TrelloConfig;
import io.restassured.RestAssured;
import models.Board;
import models.Card;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.CardPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrelloApiTest {
    private BoardPage boardPage;
    private CardPage cardPage;
    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = TrelloConfig.getBaseUrl();
        boardPage = new BoardPage();
        cardPage = new CardPage();
    }
    
    @Test
    public void trelloScenarioTest() {
        Board board = boardPage.createBoard("Test Board");
        System.out.println("Board created with ID: " + board.getId());
        
        String listId = boardPage.getFirstListId(board.getId());
        
        List<Card> cards = new ArrayList<>();
        Card card1 = cardPage.createCard(listId, "Card 1");
        Card card2 = cardPage.createCard(listId, "Card 2");
        cards.add(card1);
        cards.add(card2);
        System.out.println("Created two cards");
        
        Random random = new Random();
        Card randomCard = cards.get(random.nextInt(cards.size()));
        Card updatedCard = cardPage.updateCard(randomCard.getId(), "Updated Card");
        System.out.println("Updated random card with ID: " + updatedCard.getId());
        
        for (Card card : cards) {
            cardPage.deleteCard(card.getId());
        }
        System.out.println("Deleted all cards");
        
        boardPage.deleteBoard(board.getId());
        System.out.println("Deleted board");
    }
} 