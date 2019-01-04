package com.capstonebackend.controllers;


import com.capstonebackend.input.GameCreateInput;
import com.capstonebackend.models.Game;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@ these are annotations and theyre always scoped
@RestController
public class GameController {

    @PostMapping("/games")
    public Game create(@RequestBody GameCreateInput gameDetails) {
        return new Game(gameDetails.getOrganizer(), "Seattle");
    }
}
