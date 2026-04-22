package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.enums.AvailabilityStatus;
import fr.eni.bookhubback.businessObject.enums.BookCondition;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private Long categoryId;
    private String shortDesc;
    private String longDesc;
    private String imgUrl;
    private BookCondition condition;
    private AvailabilityStatus status;
}
