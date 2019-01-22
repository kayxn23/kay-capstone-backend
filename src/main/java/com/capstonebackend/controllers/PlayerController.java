package com.capstonebackend.controllers;

import com.capstonebackend.models.Player;
import com.capstonebackend.repositories.PlayerRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kickit")
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
    //before creating a player, check if their email exists in the db (bc that is unique)
    // if the email exists do not create
    // else if the email does not exist , go ahead and create the player
    Player newPlayer(@RequestBody Player newPlayer, @RequestHeader (name = "X-login-token", required = true) String idToken) {
        FirebaseToken decodedToken = null;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new NotAuthorizedException();
        }

        List<Player> potentialPlayer = playerRepository.findByUID(newPlayer.getUser_id());

        if(potentialPlayer.isEmpty()) {
            return playerRepository.save(newPlayer);
        }

        return potentialPlayer.get(0);
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
