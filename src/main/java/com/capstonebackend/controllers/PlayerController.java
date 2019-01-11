package com.capstonebackend.controllers;

import com.capstonebackend.models.Player;
import com.capstonebackend.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sspickup")
public class PlayerController {
    private final PlayerRepository playerRepository;

    PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Aggregate root

    @GetMapping("/players")
    public List<Player> all() {
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    //Single Item

    @GetMapping("/players/{player_id}")
    Player one(@PathVariable Long player_id) {
        return playerRepository.findById(player_id)
                .orElseThrow(() -> new PlayerNotFoundException(player_id));
    }

    @PutMapping("/players/{player_id}")
    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long player_id) {
        return playerRepository.findById(player_id)
                .map(player -> {
                    player.setFirst_name(newPlayer.getFirst_name());
                    player.setUser_name(newPlayer.getUser_name());
                    player.setGames_played(newPlayer.getGames_played());
                    player.setProfile_picture(newPlayer.getProfile_picture());
                    return playerRepository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setPlayer_id(player_id);
                    return playerRepository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{player_id}")
    void deletePlayer(@PathVariable Long player_id) {
        playerRepository.deleteById(player_id);
    }
}
