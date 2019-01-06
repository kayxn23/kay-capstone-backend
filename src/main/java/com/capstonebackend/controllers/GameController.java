package com.capstonebackend.controllers;


import com.capstonebackend.models.Game;
import com.capstonebackend.repositories.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ these are annotations and they're always scoped
@RestController
public class GameController {

    private final GameRepository repository;

    GameController(GameRepository repository) {
        this.repository = repository;
    }

    //Aggregate root

    @GetMapping("/games")
    public List<Game> all() {
                return repository.findAll();
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return repository.save(newGame);
    }

//    @PostMapping("/games")
//    public Game create(@RequestBody GameCreateInput gameDetails) {
//        return new Game(gameDetails.getOrganizer(), gameDetails.getLocation());
//    }

    //Single item

    @GetMapping("/games/{id}")
    Game one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));
    }

    @PutMapping("/games/{id}")
    Game replaceGame(@RequestBody Game newGame, @PathVariable Long id) {
        return repository.findById(id)
                .map(game -> {
                    game.setLocation(newGame.getLocation());
                    game.setOrganizer(newGame.getOrganizer());
                    return repository.save(game);
                })
                .orElseGet(() -> {
                    newGame.setId(id);
                    return repository.save(newGame);
                });
    }

    @DeleteMapping("/games/{id}")
    void deleteGame(@PathVariable Long id) {
        repository.deleteById(id);
    }



}
