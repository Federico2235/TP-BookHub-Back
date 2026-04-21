package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.BookDTO;
import fr.eni.bookhubback.exception.BookNotFoundException;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.mapper.DTOBookMapper;
import fr.eni.bookhubback.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements CrudService<Book, BookDTO> {
    //Injection de l'instance de BookRepository par contructeur via @RequiredArgsConstructor
    private final BookRepository bookRepository;
    private final DTOBookMapper dtoBookMapper;

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
}
