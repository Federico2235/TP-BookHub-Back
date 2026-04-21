package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Table(name = "USERS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
}
