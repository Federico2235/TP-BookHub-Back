package fr.eni.bookhubback.service;

import fr.eni.bookhubback.dto.BookCardResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookMockService {

    public List<BookCardResponse> getMockBooks() {
        return List.of(
                new BookCardResponse(
                        1L,
                        "Le Petit Prince",
                        "Antoine de Saint-Exupéry",
                        "Roman",
                        true,
                        "Un classique poétique sur l'enfance, l'amitié et le sens de la vie.",
                        "/assets/images/book-placeholder.jpg"
                ),
                new BookCardResponse(
                        2L,
                        "1984",
                        "George Orwell",
                        "Science-fiction",
                        false,
                        "Une dystopie sur la surveillance, le pouvoir et la liberté.",
                        "/assets/images/book-placeholder.jpg"
                ),
                new BookCardResponse(
                        3L,
                        "L'Étranger",
                        "Albert Camus",
                        "Philosophie",
                        true,
                        "Un roman majeur autour de l'absurde et de la condition humaine.",
                        "/assets/images/book-placeholder.jpg"
                )
        );
    }
}
