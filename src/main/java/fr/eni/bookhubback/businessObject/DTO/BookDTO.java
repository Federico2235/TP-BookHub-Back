package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.enums.AvailabilityStatus;
import fr.eni.bookhubback.businessObject.enums.BookCondition;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    private final String title;
    private final String author;
    private final String isbn;
    private final Long categoryId;
    private String shortDesc;
    private String longDesc;
    private String imgUrl;
    private BookCondition condition;
    private AvailabilityStatus status;
}
