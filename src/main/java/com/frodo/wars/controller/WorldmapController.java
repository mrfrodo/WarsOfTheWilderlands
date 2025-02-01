package com.frodo.wars.controller;

import com.frodo.wars.domain.Hero;
import com.frodo.wars.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Random;

@Controller
public class WorldmapController {

    private static final int ROWS = 1000;
    private static final int COLS = 1000;
    private static final String[] TERRAIN_TYPES = {"grass", "water", "mountain"};
    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/worldmap")
    public String map2(Model model) {
        model.addAttribute("message", "Welcome to the World Map. Soon to show some terrain...please wait...");
        return "worldmap";
    }

    @GetMapping("/worldmap2")
    public String map1(Model model) {
        Iterable<Hero> heroes = heroRepository.findAll();
        model.addAttribute("heroes", heroes);
        return "worldmap2";
    }

    @GetMapping("/api/map")
    @ResponseBody
    public String[][] generateWorldMap() {
        Random random = new Random();
        String[][] map = new String[ROWS][COLS];
        // Generate random terrain
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                map[row][col] = TERRAIN_TYPES[random.nextInt(TERRAIN_TYPES.length)];
            }
        }
        return map;
    }
}
