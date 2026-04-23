package fr.eni.bookhubback.mapper;

import fr.eni.bookhubback.businessObject.DTO.UserDTO;
import fr.eni.bookhubback.businessObject.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DTOUserMapper {

    private final EntityManager entityManager;

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRole(user.getRole());

        return userDTO;
    }
    //Convertit un userDTO en une instance de user en utilisant un constructeur vide + setters
    public User toUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setPassword(userDTO.getPassword());

       return user;
    }
}
