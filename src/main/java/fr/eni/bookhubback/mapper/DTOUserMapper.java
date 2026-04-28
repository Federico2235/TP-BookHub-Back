package fr.eni.bookhubback.mapper;

import fr.eni.bookhubback.businessObject.DTO.UserCreateDTO;
import fr.eni.bookhubback.businessObject.DTO.UserResponseDTO;
import fr.eni.bookhubback.businessObject.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DTOUserMapper {

    public User toUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        user.setEmail(userCreateDTO.getEmail());
        user.setRole(userCreateDTO.getRole());
        user.setPassword(userCreateDTO.getPassword());
        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getId());
        userResponseDTO.setFirstName(user.getFirstName());
        userResponseDTO.setLastName(user.getLastName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setRole(user.getRole());
        return userResponseDTO;
    }
}


