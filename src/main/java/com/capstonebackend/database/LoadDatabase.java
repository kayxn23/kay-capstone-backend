//package com.capstonebackend.database;
//
//import com.capstonebackend.models.Game;
//import com.capstonebackend.models.Player;
//import com.capstonebackend.repositories.GameRepository;
//import com.capstonebackend.repositories.PlayerRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Slf4j
//public class LoadDatabase {
//
//    @Bean
//    CommandLineRunner initDatabase(PlayerRepository playerRepository) {
//        return args -> {
//            log.info("Preloading " + playerRepository.save(new Player("Anna", "anna23", 0, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png")));
//
//        };
//    }
//}
//

