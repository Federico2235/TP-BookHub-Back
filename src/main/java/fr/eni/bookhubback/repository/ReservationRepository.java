package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByUserId(long userId);
    Reservation findByUserIdAndBookId(long userId, long bookId);
}
