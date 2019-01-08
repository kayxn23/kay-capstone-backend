package com.capstonebackend.controllers;


import com.capstonebackend.models.Game;
import com.capstonebackend.repositories.GameRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ these are annotations and they're always scoped
@RestController
@RequestMapping("/api")
public class GameController {
    private final GameRepository gameRepository;

    GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //Aggregate root

    @GetMapping("/games")
    public List<Game> all() {
                return gameRepository.findAll();
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return gameRepository.save(newGame);
    }

//    @PostMapping("/games")
//    public Game create(@RequestBody GameCreateInput gameDetails) {
//        return new Game(gameDetails.getOrganizer(), gameDetails.getLocation());
//    }

    //Single item

    @GetMapping("/games/{id}")
    Game one(@PathVariable Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @PutMapping("/games/{id}")
    Game replaceGame(@RequestBody Game newGame, @PathVariable Long id) {
        return gameRepository.findById(id)
                .map(game -> {
                    game.setLocation(newGame.getLocation());
                    game.setOrganizer(newGame.getOrganizer());
                    return gameRepository.save(game);
                })
                .orElseGet(() -> {
                    newGame.setId(id);
                    return gameRepository.save(newGame);
                });
    }

    @DeleteMapping("/games/{id}")
    void deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }



}
