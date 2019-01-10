//package com.capstonebackend.database;
//
//import com.capstonebackend.models.Game;
//import com.capstonebackend.models.User;
//import com.capstonebackend.repositories.GameRepository;
//import com.capstonebackend.repositories.UserRepository;
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
//    CommandLineRunner initDatabase(UserRepository userRepository) {
//        return args -> {
//            log.info("Preloading " + userRepository.save(new User("Test Name ", "name23", 5 )));
//
//        };
//    }
//}