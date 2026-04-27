package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.BookDTO;
import fr.eni.bookhubback.businessObject.entity.Category;
import fr.eni.bookhubback.exception.BookNotFoundException;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.mapper.DTOBookMapper;
import fr.eni.bookhubback.repository.BookRepository;
import fr.eni.bookhubback.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements CrudService<Book, BookDTO> {
    //Injection de l'instance de BookRepository par contructeur via @RequiredArgsConstructor
    private final BookRepository bookRepository;
    private final DTOBookMapper dtoBookMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Book> selectAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book selectById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(BookDTO bookDto) {
        return bookRepository.save(dtoBookMapper.toBook(bookDto));
    }

    public Book patchBook(long id, BookDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }

        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }

        if (dto.getIsbn() != null) {
            book.setIsbn(dto.getIsbn());
        }

        if (dto.getShortDesc() != null) {
            book.setShortDesc(dto.getShortDesc());
        }

        if (dto.getLongDesc() != null) {
            book.setLongDesc(dto.getLongDesc());
        }

        if (dto.getImgUrl() != null) {
            book.setImgUrl(dto.getImgUrl());
        }

        if (dto.getCondition() != null) {
            book.setCondition(dto.getCondition());
        }

        if (dto.getStatus() != null) {
            book.setStatus(dto.getStatus());
        }

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            book.setCategory(category);
        }

        return bookRepository.save(book);
    }
}
