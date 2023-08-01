package com.example.VirtualPetAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(VirtualPetRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new VirtualPet("Bilbo Baggins", "A good girl", "Organic", "Dog", "Male")));
      log.info("Preloading " + repository.save(new VirtualPet("Frodo Baggins", "Steals treats when no one is looking", "Robotic", "Cat", "Female")));
    };
  }
}