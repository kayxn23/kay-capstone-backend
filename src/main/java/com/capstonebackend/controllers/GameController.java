package com.capstonebackend.controllers;


import com.capstonebackend.models.Game;
import com.capstonebackend.repositories.GameRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ these are annotations and they're always scoped
@RestController
@RequestMapping("/sspickup")
public class GameController {
    private final GameRepository gameRepository;

    GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //Aggregate root

    //add query variable in /games?location_id={id}

    @GetMapping(value = "/games", produces = "application/json; charset=UTF-8")
    public List<Game> all(@RequestParam(required = false) Long location_id) {
        if (location_id != null) {
            return gameRepository.findByLocationId(location_id);
        } else {
            return gameRepository.findAll();
        }
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

    @GetMapping("/games/{game_id}")
    Game one(@PathVariable Long game_id) {
        return gameRepository.findById(game_id)
                .orElseThrow(() -> new GameNotFoundException(game_id));
    }

    @PutMapping("/games/{game_id}")
    Game replaceGame(@RequestBody Game newGame, @PathVariable Long game_id) {
        return gameRepository.findById(game_id)
                .map(game -> {
                    game.setTitle(newGame.getTitle());
                    game.setDescription(newGame.getDescription());
                    game.setLocation_id(newGame.getLocation_id());
                    game.setGame_date(newGame.getGame_date());

                    return gameRepository.save(game);
                })
                .orElseGet(() -> {
                    newGame.setGame_id(game_id);
                    return gameRepository.save(newGame);
                });
    }

    @DeleteMapping("/games/{game_id}")
    void deleteGame(@PathVariable Long game_id) {
        gameRepository.deleteById(game_id);
    }



}
