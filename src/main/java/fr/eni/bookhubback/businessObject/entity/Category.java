package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    String label;
}
