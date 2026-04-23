package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.enums.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
