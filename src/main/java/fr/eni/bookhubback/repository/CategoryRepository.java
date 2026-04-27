package fr.eni.bookhubback.repository;

import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
