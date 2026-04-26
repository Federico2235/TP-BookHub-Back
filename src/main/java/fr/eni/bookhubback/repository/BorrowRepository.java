package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    boolean existsByBookIdAndReturnDateIsNull(Long bookId);
    List<Borrow> findAllByUserId(long userId);
    boolean existsByUserIdAndBookIdAndReturnDateIsNull(Long userId, Long bookId);
}
