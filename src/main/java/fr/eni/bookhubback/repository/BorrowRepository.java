package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
    boolean existsByBookIdAndReturnDateIsNull(Long bookId);

    boolean existsByUserIdAndBookIdAndReturnDateIsNull(Long userId, Long bookId);
}
