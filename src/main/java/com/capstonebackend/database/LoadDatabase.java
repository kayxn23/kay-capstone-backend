package com.capstonebackend.database;

import com.capstonebackend.models.Game;
import com.capstonebackend.repositories.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(GameRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Game("OrganizerTest1", "LocationTest1" )));
            log.info("Preloading " + repository.save(new Game("OrganizerTest2", "LocationTest2" )));

        };
    }
}
