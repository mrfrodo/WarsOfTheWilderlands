package com.frodo.wars.mapgenerators;

import java.util.Random;

// Main class
public class HexMapGenerator {
    public static void main(String[] args) {
        HexMap map = new HexMap(10, 10);
        map.printMap();
    }
}

class HexMap {
    private int width, height;
    private Hex[][] grid;
    private Random rand;

    public HexMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Hex[width][height];
        this.rand = new Random();
        generateMap();
    }

    // Procedural generation function
    private void generateMap() {
        for (int q = 0; q < width; q++) {
            for (int r = 0; r < height; r++) {
                TerrainType terrain = generateTerrain(q, r);
                grid[q][r] = new Hex(q, r, terrain);
            }
        }
    }

    // Generate terrain type using noise
    private TerrainType generateTerrain(int q, int r) {
        double noiseValue = Math.sin(q * 0.3) + Math.cos(r * 0.3); // Basic noise simulation
        if (noiseValue > 0.5) return TerrainType.MOUNTAINS;
        else if (noiseValue < -0.5) return TerrainType.RIVER;
        else return TerrainType.PLAINS;
    }

    // Print the map
    public void printMap() {
        for (int r = 0; r < height; r++) {
            for (int q = 0; q < width; q++) {
                System.out.print(grid[q][r].terrain.toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }
}

// Hex tile class
class Hex {
    int q, r;
    TerrainType terrain;

    public Hex(int q, int r, TerrainType terrain) {
        this.q = q;
        this.r = r;
        this.terrain = terrain;
    }
}
