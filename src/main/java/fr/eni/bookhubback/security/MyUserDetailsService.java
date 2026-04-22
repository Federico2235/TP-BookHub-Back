package fr.eni.bookhubback.security;

import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static fr.eni.bookhubback.businessObject.enums.Role.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.userRepository = userRepository;

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            User m1 = new User("Cyril", "Mace", "membre1@test.com", passwordEncoder.encode("membre1"), MEMBER);
            User m2 = new User("Eric", "Legrand", "membre2@test.com", passwordEncoder.encode("membre2"), LIBRARIAN);
            User m3 = new User("Patricia", "Martin", "admin@test.com", passwordEncoder.encode("admin"), ADMIN);

            userRepository.save(m1);
            userRepository.save(m2);
            userRepository.save(m3);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFound = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new UserSpringSecurity(userFound);
    }
}