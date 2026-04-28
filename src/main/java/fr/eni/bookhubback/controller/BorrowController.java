package fr.eni.bookhubback.controller;

import fr.eni.bookhubback.businessObject.DTO.BookDTO;
import fr.eni.bookhubback.businessObject.DTO.BorrowCreateDTO;
import fr.eni.bookhubback.businessObject.DTO.BorrowResponseDTO;
import fr.eni.bookhubback.businessObject.DTO.ReturnDateDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.exception.BorrowNotFoundException;
import fr.eni.bookhubback.exception.UserNotFoundException;
import fr.eni.bookhubback.mapper.DTOBorrowMapper;
import fr.eni.bookhubback.service.BookService;
import fr.eni.bookhubback.service.BorrowService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowController {

    private final BorrowService borrowService;
    private final DTOBorrowMapper dtoBorrowMapper;
    private final BookService bookService;


    @GetMapping("/api/borrows")
    public List<BorrowResponseDTO> getBorrows() {
        return borrowService.selectAll().stream()
                .map(dtoBorrowMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/api/borrows/user/{id}")
    public ResponseEntity<?> getReservation(@PathVariable long id) {
        try {
            List<Borrow> borrows = borrowService.findByUserId(id);
            return ResponseEntity.ok(borrows);

        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }


    @GetMapping("/api/borrows/{id}")
    public ResponseEntity<?> getBorrow(@PathVariable long id) {
        try {
            Borrow borrow = borrowService.selectById(id);
            return ResponseEntity.ok(dtoBorrowMapper.toResponseDTO(borrow));

        } catch (BorrowNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    /**
     * Crée un nouvel emprunt pour un livre.
     * Vérifie que le livre est disponible, gère la réservation éventuelle
     * et met à jour le statut du livre en conséquence.
     */

    @PostMapping("/api/borrows")
    public ResponseEntity<?> saveBorrow(@RequestBody @Nonnull @Validated BorrowCreateDTO borrowCreateDTO) {
        borrowService.save(borrowCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(borrowCreateDTO);
    }

    @DeleteMapping("/api/borrows/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        try {
            borrowService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (BorrowNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    /**
     * Met à jour la date de retour d’un emprunt existant.
     * Vérifie que la date de retour n’est pas antérieure à la date de début d’emprunt.
     * Si une date de retour est définie, le livre associé est marqué comme disponible.
     *
     * @param id identifiant de l’emprunt à mettre à jour
     * @param dto objet contenant la nouvelle date de retour
     * @return l’emprunt mis à jour
     */
    @PatchMapping("/api/borrows/{id}/return-date")
    public Borrow updateReturnDate(
            @PathVariable long id,
            @RequestBody ReturnDateDTO dto
    ) {
        return borrowService.updateReturnDate(id, dto);
    }

    @GetMapping("/api/borrows/book/{id}")
    public ResponseEntity<?> getBorrowByBookId(@PathVariable long id) {
        try {
            Borrow borrow = borrowService.findByBookId(id);
            return ResponseEntity.ok(dtoBorrowMapper.toResponseDTO(borrow));

        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
