package fr.eni.bookhubback.controller;


import fr.eni.bookhubback.dto.BookCardResponse;
import fr.eni.bookhubback.service.BookMockService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    private final BookMockService bookMockService;

    public BookController(BookMockService bookMockService) {
        this.bookMockService = bookMockService;
    }

    @GetMapping
    public List<BookCardResponse> getBooks() {
        return bookMockService.getMockBooks();
    }
}