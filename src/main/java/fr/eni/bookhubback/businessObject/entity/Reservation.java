package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Setter
    @OneToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @Column()
    private Date date = new Date();
}
