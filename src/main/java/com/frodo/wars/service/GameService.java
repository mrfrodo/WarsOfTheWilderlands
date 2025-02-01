package com.frodo.wars.service;

import com.frodo.wars.domain.Game;
import com.frodo.wars.domain.GameState;
import com.frodo.wars.domain.MoveUnitRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameService {

    private Map<String, Game> activeGames = new HashMap<>();
    private Game currentGame;

    // Start a new game and return the game code
    public String startNewGame() {
        String gameCode = UUID.randomUUID().toString();
        Game newGame = new Game(gameCode);
        activeGames.put(gameCode, newGame);
        this.currentGame = newGame;
        return gameCode;
    }

    // Join an existing game
    public boolean joinGame(String gameCode) {
        Game game = activeGames.get(gameCode);
        if (game != null) {
            game.addPlayer("Player " + (game.getPlayers().size() + 1));
            return true;
        }
        return false;
    }

    // End the current turn
    public boolean endTurn() {
        if (currentGame != null) {
            currentGame.endCurrentTurn();
            return true;
        }
        return false;
    }

    // Get the current game state
    public GameState getGameState() {
        if (currentGame != null) {
            return currentGame.getGameState();
        }
        return null;
    }

    // Move a unit on the game board
    public boolean moveUnit(MoveUnitRequest moveUnitRequest) {
        if (currentGame != null) {
            return currentGame.moveUnit(moveUnitRequest.getUnitId(), moveUnitRequest.getToX(), moveUnitRequest.getToY());
        }
        return false;
    }
}
