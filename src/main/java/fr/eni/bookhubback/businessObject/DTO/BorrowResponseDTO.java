package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BorrowResponseDTO {
    private long borrowId;
    private UserResponseDTO user;
    private Book book;
    private LocalDate borrowStart;
    private LocalDate borrowEnd;
    private LocalDate returnDate;
}


