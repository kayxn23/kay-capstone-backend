package com.capstonebackend.controllers;


import com.capstonebackend.input.GameCreateInput;
import com.capstonebackend.models.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@ these are annotations and they're always scoped
@RestController
public class GameController {

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return Arrays.asList(
                new Game("Organizer1", "Location1"));
    }



    @PostMapping("/games")
    public Game create(@RequestBody GameCreateInput gameDetails) {
        return new Game(gameDetails.getOrganizer(), gameDetails.getLocation());
    }
}
