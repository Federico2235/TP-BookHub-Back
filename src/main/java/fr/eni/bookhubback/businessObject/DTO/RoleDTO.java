package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {
   private Role role;
}
