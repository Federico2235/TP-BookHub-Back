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

    //Pour DEV : Ajout de 10 utilisateurs aux profils divers
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User("Cyril", "Mace", "membre1@test.com", passwordEncoder.encode("membre1"), MEMBER));
                userRepository.save(new User("Eric", "Legrand", "bibli1@test.com", passwordEncoder.encode("bibli1"), LIBRARIAN));
                userRepository.save(new User("Patricia", "Martin", "admin@test.com", passwordEncoder.encode("admin"), ADMIN));
                userRepository.save(new User("Jean-Michel", "Dutrou", "membre2@test.com", passwordEncoder.encode("membre2"), MEMBER));
                userRepository.save(new User("Sylvie", "Durant", "bibli2@test.com", passwordEncoder.encode("bibli2"), LIBRARIAN));
                userRepository.save(new User("Jacques", "Brel", "membre3@test.com", passwordEncoder.encode("membre3"), MEMBER));
                userRepository.save(new User("Cindy", "Loper", "membre4@test.com", passwordEncoder.encode("membre4"), MEMBER));
                userRepository.save(new User("Maggy", "Priz", "membre5@test.com", passwordEncoder.encode("membre5"), MEMBER));
                userRepository.save(new User("Mac", "Miller", "membre6@test.com", passwordEncoder.encode("membre6"), MEMBER));
                userRepository.save(new User("James", "La Galette", "membre7@test.com", passwordEncoder.encode("membre7"), MEMBER));
            }
        };
    }
}
