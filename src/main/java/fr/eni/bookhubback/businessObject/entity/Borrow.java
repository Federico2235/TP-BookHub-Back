package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "BORROW")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long borrowId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @Column(nullable = false)
    private LocalDate borrowStart;
    @Column(nullable = false)
    private LocalDate borrowEnd;
    private LocalDate returnDate;
}
