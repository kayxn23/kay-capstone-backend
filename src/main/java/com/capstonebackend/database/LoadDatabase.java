//package com.capstonebackend.database;
//
//import com.capstonebackend.models.Game;
//import com.capstonebackend.models.Player;
//import com.capstonebackend.repositories.GameRepository;
//import com.capstonebackend.repositories.PlayerRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//public class LoadDatabase {
//
//    @Bean
//    CommandLineRunner initDatabase(PlayerRepository userRepository) {
//        return args -> {
//            log.info("Preloading " + userRepository.save(new Player("Test Name ", "name23", 5 )));
//
//        };
//    }
//}