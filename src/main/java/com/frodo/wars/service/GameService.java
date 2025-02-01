package com.frodo.wars.service;

import com.frodo.wars.domain.Game;
import com.frodo.wars.domain.GameState;
import com.frodo.wars.domain.MoveUnitRequest;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class GameService {

    private Map<String, Game> activeGames = new HashMap<>();
    private Game currentGame;

    public Map<String, Object> startNewGame(int width, int height) {
        TerrainTile[][] battleMap = generateBattleMap(width, height);
        String gameCode = generateGameCode();

        Map<String, Object> response = new HashMap<>();
        response.put("map", battleMap);
        response.put("gameCode", gameCode);
        return response;
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

    private TerrainTile[][] generateBattleMap(int width, int height) {
        TerrainTile[][] map = new TerrainTile[height][width];
        Random random = new Random();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rand = random.nextInt(10); // Adjust this range for more/less variability

                String type;
                String color;

                // Adjust probabilities for more mountains and fewer rivers
                if (rand < 1) {  // 10% chance for river
                    type = "river";
                    color = "#1E90FF"; // Blue
                } else if (rand < 4) { // 30% chance for mountain
                    type = "mountain";
                    color = "#696969"; // Dark Gray
                } else if (rand < 6) { // 20% chance for hill
                    type = "hill";
                    color = "#8B4513"; // Brown
                } else {  // 40% chance for plain
                    type = "plain";
                    color = "#228B22"; // Green
                }

                map[y][x] = new TerrainTile(type, color);
            }
        }
        return map;
    }

    static class TerrainTile {
        public String type;
        public String color;

        public TerrainTile(String type, String color) {
            this.type = type;
            this.color = color;
        }
    }


    private String generateGameCode() {
        return UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

}
