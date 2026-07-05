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

}
