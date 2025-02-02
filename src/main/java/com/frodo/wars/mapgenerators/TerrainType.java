package com.frodo.wars.mapgenerators;

import java.awt.*;

// Enum for terrain types
enum TerrainType {
    PLAINS(new Color(144, 238, 144)),  // Light Green
    MOUNTAINS(new Color(139, 137, 137)), // Gray
    RIVER(new Color(30, 144, 255)); // Blue

    private final Color color;

    TerrainType(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}