package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
