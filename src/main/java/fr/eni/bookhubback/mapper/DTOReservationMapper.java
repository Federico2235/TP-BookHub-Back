package fr.eni.bookhubback.mapper;

import fr.eni.bookhubback.businessObject.DTO.ReservationDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DTOReservationMapper {

    private final EntityManager entityManager;

    public Reservation toReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setUser(entityManager.getReference(User.class, reservationDTO.userId()));
        reservation.setBook(entityManager.getReference(Book.class, reservationDTO.bookId()));
        return reservation;
    }
}
