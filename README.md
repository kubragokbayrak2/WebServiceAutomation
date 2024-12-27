# Trello API Automation Project

This project demonstrates automation testing of Trello API using Rest Assured and TestNG.

## Prerequisites

- Java 11 or higher
- Maven
- Trello Account with API Key and Token

## Setup

1. Get your Trello API credentials:
   - Visit https://trello.com/app-key to get your API Key
   - Get your Token by logging into Trello and visiting the token URL

2. Update the credentials in `src/main/java/config/TrelloConfig.java`:
   - Replace `YOUR_API_KEY` with your Trello API Key
   - Replace `YOUR_TOKEN` with your Trello Token

## Project Structure

- `config` - Contains configuration class for Trello API credentials
- `models` - Contains POJO classes for Trello entities (Board, Card)
- `services` - Contains service class for Trello API operations
- `tests` - Contains test class implementing the scenario

## Running Tests

To run the tests, execute the following command in the project root directory:

```bash
mvn clean test
```

## Test Scenario

The test performs the following steps:
1. Creates a new Trello board
2. Creates two cards on the board
3. Updates a random card
4. Deletes both cards
5. Deletes the board

## Technologies Used

- Java
- Maven
- REST Assured
- TestNG
- Lombok
- Log4j 