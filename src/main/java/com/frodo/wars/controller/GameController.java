package com.frodo.wars.controller;

import com.frodo.wars.domain.GameState;
import com.frodo.wars.domain.MoveUnitRequest;
import com.frodo.wars.service.GameService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Endpoint to start a new game
    @PostMapping("/startGame")
    public Map<String, Object> startGame() {
        int width = 40;  // Map width
        int height = 15; // Map height

        return gameService.startNewGame(width, height);
    }

    // Endpoint to join an existing game
    @PostMapping("/joinGame")
    public Map<String, String> joinGame(@RequestBody Map<String, String> request) {
        String gameCode = request.get("gameCode");
        boolean success = gameService.joinGame(gameCode);
        Map<String, String> response = new HashMap<>();
        if (success) {
            response.put("message", "Successfully joined game: " + gameCode);
        } else {
            response.put("message", "Game with code " + gameCode + " not found.");
        }
        return response;
    }

    // Endpoint to end the current player's turn
    @PostMapping("/endTurn")
    public Map<String, String> endTurn() {
        boolean success = gameService.endTurn();
        Map<String, String> response = new HashMap<>();
        if (success) {
            response.put("message", "Turn ended successfully.");
        } else {
            response.put("message", "Error ending turn.");
        }
        return response;
    }

    // Endpoint to get the current game state (board, units, players)
    @GetMapping("/gameState")
    public GameState getGameState() {
        return gameService.getGameState();
    }

    // Endpoint to move a unit from one grid position to another
    @PostMapping("/moveUnit")
    public Map<String, String> moveUnit(@RequestBody MoveUnitRequest moveUnitRequest) {
        boolean success = gameService.moveUnit(moveUnitRequest);
        Map<String, String> response = new HashMap<>();
        if (success) {
            response.put("message", "Unit moved successfully.");
        } else {
            response.put("message", "Error moving unit.");
        }
        return response;
    }

    // Endpoint to move a unit from one grid position to another
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request) {
        return new HashMap<>();
    }


}
