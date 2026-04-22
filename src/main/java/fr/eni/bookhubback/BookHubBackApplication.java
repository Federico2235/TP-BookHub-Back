package fr.eni.bookhubback;

import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static fr.eni.bookhubback.businessObject.enums.Role.*;

@SpringBootApplication
public class BookHubBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookHubBackApplication.class, args);
    }


    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User("Cyril", "Mace", "membre1@test.com", passwordEncoder.encode("membre1"), MEMBER));
                userRepository.save(new User("Eric", "Legrand", "membre2@test.com", passwordEncoder.encode("membre2"), LIBRARIAN));
                userRepository.save(new User("Patricia", "Martin", "admin@test.com", passwordEncoder.encode("admin"), ADMIN));
            }
        };
    }
}
