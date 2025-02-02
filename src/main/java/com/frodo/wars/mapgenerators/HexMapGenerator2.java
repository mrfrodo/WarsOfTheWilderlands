package com.frodo.wars.mapgenerators;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Main JFrame class
public class HexMapGenerator2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HexMap2 map = new HexMap2(10, 10);
            JFrame frame = new JFrame("Hex Map Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            HexMapPanel comp = new HexMapPanel(map);
            frame.add(comp);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// Hex tile class
class Hex2 {
    int q, r;
    TerrainType terrain;

    public Hex2(int q, int r, TerrainType terrain) {
        this.q = q;
        this.r = r;
        this.terrain = terrain;
    }
}

// Hexagonal grid map
class HexMap2 {
    private int cols, rows;
    private Hex2[][] grid;
    private Random rand;
    private final int HEX_SIZE = 30; // Size of hexagon

    public HexMap2(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.grid = new Hex2[cols][rows];
        this.rand = new Random();
        generateMap();
    }

    // Procedural generation
    private void generateMap() {
        for (int q = 0; q < cols; q++) {
            for (int r = 0; r < rows; r++) {
                TerrainType terrain = generateTerrain(q, r);
                grid[q][r] = new Hex2(q, r, terrain);
            }
        }
    }

    // Generate terrain using noise
    private TerrainType generateTerrain(int q, int r) {
        double noiseValue = Math.sin(q * 0.3) + Math.cos(r * 0.3); // Basic noise effect
        if (noiseValue > 0.5) return TerrainType.MOUNTAINS;
        else if (noiseValue < -0.5) return TerrainType.RIVER;
        else return TerrainType.PLAINS;
    }

    public Hex2[][] getGrid() {
        return grid;
    }

    public int getHexSize() {
        return HEX_SIZE;
    }
}

// JPanel for rendering hex map
class HexMapPanel extends JPanel {
    private final HexMap2 map;
    private final int HEX_SIZE;

    public HexMapPanel(HexMap2 map) {
        this.map = map;
        this.HEX_SIZE = map.getHexSize();
        setPreferredSize(new Dimension(600, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Hex2[][] grid = map.getGrid();
        for (Hex2[] hexRow : grid) {
            for (Hex2 hex : hexRow) {
                drawHex(g2, hex);
            }
        }
    }

    // Draw a single hexagon
    private void drawHex(Graphics2D g2, Hex2 hex) {
        int xOffset = HEX_SIZE * 3 / 2 * hex.q;
        int yOffset = (int) (HEX_SIZE * Math.sqrt(3) * (hex.r + (hex.q * 0.5)));

        Polygon hexagon = createHexagon(xOffset, yOffset);
        g2.setColor(hex.terrain.getColor());
        g2.fillPolygon(hexagon);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(hexagon);
    }

    // Create a hexagon shape
    private Polygon createHexagon(int x, int y) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];

        for (int i = 0; i < 6; i++) {
            double angle = Math.PI / 3 * i;
            xPoints[i] = (int) (x + HEX_SIZE * Math.cos(angle));
            yPoints[i] = (int) (y + HEX_SIZE * Math.sin(angle));
        }
        return new Polygon(xPoints, yPoints, 6);
    }
}


