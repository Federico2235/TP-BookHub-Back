package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Reservation {
    @Id
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private long copyId;
}
