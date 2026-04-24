package fr.eni.bookhubback.businessObject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowCreateDTO {
    private long userId;
    private long bookId;
    private LocalDate borrowStart;
    private LocalDate borrowEnd;
    private LocalDate returnDate;
}
