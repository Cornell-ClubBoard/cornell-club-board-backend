package com.example.cornell_club_board.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository) {
        return args -> {
            User dylan1 = new User(
                    1L,
                    "dylanvig1@gmail.com",
                    "dylanvig1"
            );
            User dylan2 = new User(
                    "dylanvig324@gmail.com",
                    "dylanvig2"
            );
            repository.saveAll(List.of(dylan1, dylan2));
        };
    }

}
