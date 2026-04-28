package fr.eni.bookhubback.businessObject.DTO;

import fr.eni.bookhubback.businessObject.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationResponseDTO {
    private long id;
    private UserResponseDTO user;
    private Book book;
    private Date date;
}