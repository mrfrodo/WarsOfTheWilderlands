package com.frodo.wars.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String gameCode;
    private List<String> players;
    private int currentPlayerIndex;
    private GameState gameState;

    public Game(String gameCode) {
        this.gameCode = gameCode;
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.gameState = new GameState(); // Initialize with an empty game state
    }

    public String getGameCode() {
        return gameCode;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void addPlayer(String player) {
        players.add(player);
    }

    public void endCurrentTurn() {
        // Logic to end the current player's turn and switch to the next
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public GameState getGameState() {
        return gameState;
    }

    public boolean moveUnit(String unitId, int toX, int toY) {
        // Logic for moving the unit on the game board
        return gameState.moveUnit(unitId, toX, toY);
    }
}
