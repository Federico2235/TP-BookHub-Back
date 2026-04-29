package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.DTO.RoleDTO;
import fr.eni.bookhubback.businessObject.DTO.UserResponseDTO;
import fr.eni.bookhubback.businessObject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
