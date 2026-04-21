package fr.eni.bookhubback.businessObject.entity;

import fr.eni.bookhubback.businessObject.enums.AvailabilityStatus;
import fr.eni.bookhubback.businessObject.enums.BookCondition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "BOOK")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @Setter
    private String title;
    @Column(nullable = false)
    @Setter
    private String author;
    @Column(length = 13, nullable = false)
    @Setter
    private String isbn;
    @Setter
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Setter
    @Column(length = 400)
    private String shortDesc;
    @Setter
    @Column(length = 1000)
    private String longDesc;
    @Setter
    private String imgUrl;
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCondition condition = BookCondition.PRISTINE;
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AvailabilityStatus status = AvailabilityStatus.BLOCKED;
}
