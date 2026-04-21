package fr.eni.bookhubback.mapper;

import fr.eni.bookhubback.businessObject.DTO.BookDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Category;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DTOBookMapper {

    private final EntityManager entityManager;

    public BookDTO toDTO(Book book) {
        BookDTO bookDTO = new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getCategory().getId()
        );
        if(!book.getShortDesc().isBlank()) {
            bookDTO.setShortDesc(book.getShortDesc());
        }
        if(!book.getLongDesc().isBlank()) {
            bookDTO.setShortDesc(book.getLongDesc());
        }
        if(!book.getImgUrl().isBlank()) {
            bookDTO.setShortDesc(book.getImgUrl());
        }
        if(!book.getCondition().name.isBlank()) {
            bookDTO.setShortDesc(book.getCondition().name);
        }
        if(!book.getStatus().name.isBlank()) {
            bookDTO.setShortDesc(book.getStatus().name);
        }
        return bookDTO;
    }

    public Book toBook(BookDTO bookDTO) {
        Category category  = entityManager.getReference(Category.class, bookDTO.getCategoryId());
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setCategory(category);
        if(!bookDTO.getShortDesc().isBlank()) {
            book.setShortDesc(bookDTO.getShortDesc());
        }
        if(!bookDTO.getLongDesc().isBlank()) {
            book.setShortDesc(bookDTO.getLongDesc());
        }
        if(!bookDTO.getImgUrl().isBlank()) {
            book.setShortDesc(bookDTO.getImgUrl());
        }
        if(!bookDTO.getCondition().name.isBlank()) {
            book.setShortDesc(bookDTO.getCondition().name);
        }
        if(!bookDTO.getStatus().name.isBlank()) {
            book.setShortDesc(bookDTO.getStatus().name);
        }
       return book;
    }
}
