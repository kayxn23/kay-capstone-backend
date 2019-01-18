package com.capstonebackend.controllers;


import com.capstonebackend.models.Game;
import com.capstonebackend.models.Player;
import com.capstonebackend.repositories.GameRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //pass in a player object from react to here marked body
    @PatchMapping("/games/{game_id}/join")
    public Game joinGame(@RequestBody Player newlyJoinedPlayer, @PathVariable Long game_id) {
        Optional<Game> potentialGame = gameRepository.findById(game_id);
        if(potentialGame.isPresent()) {
            Game existingGame = potentialGame.get();

            existingGame.getPlayers().add(newlyJoinedPlayer);

            return gameRepository.save(existingGame);
        } else {
            throw new GameNotFoundException(game_id);
        }
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame) {
        return gameRepository.save(newGame);
    }

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
                    game.setLocation(newGame.getLocation());
                    game.setGame_date(newGame.getGame_date());
                    game.setOrganizer(newGame.getOrganizer());

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
