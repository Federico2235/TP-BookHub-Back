package fr.eni.bookhubback.controller;
import fr.eni.bookhubback.businessObject.DTO.UserDTO;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.service.UserService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.selectAll();
    }

    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.selectById(id);
    }

    @PostMapping("/api/users")
    public User saveUser(@RequestBody @Nonnull @Validated UserDTO user) {
        return userService.save(user);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
