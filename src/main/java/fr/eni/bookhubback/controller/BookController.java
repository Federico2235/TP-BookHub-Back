package fr.eni.bookhubback.controller;

import fr.eni.bookhubback.businessObject.DTO.BookDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.service.BookService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return bookService.selectAll();
    }

    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.selectById(id);
    }

    @PostMapping("/api/books")
    public Book saveBook(@RequestBody @Nonnull @Validated BookDTO book) {
        return bookService.save(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.delete(id);
    }
}
