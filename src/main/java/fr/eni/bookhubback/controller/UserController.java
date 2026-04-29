package fr.eni.bookhubback.controller;
import fr.eni.bookhubback.businessObject.DTO.ReturnDateDTO;
import fr.eni.bookhubback.businessObject.DTO.RoleDTO;
import fr.eni.bookhubback.businessObject.DTO.UserCreateDTO;
import fr.eni.bookhubback.businessObject.DTO.UserResponseDTO;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.exception.UserNotFoundException;
import fr.eni.bookhubback.service.UserService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import fr.eni.bookhubback.mapper.DTOUserMapper;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final DTOUserMapper dtoUserMapper;


    @GetMapping("/api/users")
    public List<UserResponseDTO> getUsers() {
        return userService.selectAll().stream()
                .map(dtoUserMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        try {
            User user = userService.selectById(id);
            return ResponseEntity.ok(dtoUserMapper.toResponseDTO(user));

        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> saveUser(@RequestBody @Nonnull @Validated UserCreateDTO user) {

        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User with this email already exists");
        }
        User savedUser = userService.save(user);
        UserResponseDTO responseDTO = dtoUserMapper.toResponseDTO(savedUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }

    @PatchMapping("/api/users/{id}/role")
    public UserResponseDTO updateRole(
            @PathVariable long id,
            @RequestBody RoleDTO dto
    ) {
        User user = userService.updateRole(id, dto);
        return dtoUserMapper.toResponseDTO(user);
    }

}
