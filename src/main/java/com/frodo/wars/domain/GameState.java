package com.frodo.wars.domain;

import java.util.HashMap;
import java.util.Map;

public class GameState {

    private Map<String, Unit> units;

    public GameState() {
        this.units = new HashMap<>();
        // Initialize units on the board if necessary
    }

    public boolean moveUnit(String unitId, int toX, int toY) {
        Unit unit = units.get(unitId);
        if (unit != null) {
            unit.setX(toX);
            unit.setY(toY);
            return true;
        }
        return false;
    }

    // Add more methods as needed for board, players, units, etc.
}
