package fr.eni.bookhubback.businessObject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "BORROW")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long borrowId;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false)
    private long bookId;
    @Column(nullable = false)
    private Date borrowStart;
    @Column(nullable = false)
    private Date borrowEnd;
    @Column(nullable = false)
    private Date returnDate;
}
