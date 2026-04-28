package fr.eni.bookhubback.service;


import fr.eni.bookhubback.businessObject.DTO.BorrowCreateDTO;
import fr.eni.bookhubback.businessObject.DTO.ReturnDateDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.enums.AvailabilityStatus;
import fr.eni.bookhubback.exception.BookNotFoundException;
import fr.eni.bookhubback.exception.BorrowNotFoundException;
import fr.eni.bookhubback.exception.UserNotFoundException;
import fr.eni.bookhubback.mapper.DTOBorrowMapper;
import fr.eni.bookhubback.repository.BookRepository;
import fr.eni.bookhubback.repository.BorrowRepository;
import fr.eni.bookhubback.repository.ReservationRepository;
import fr.eni.bookhubback.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BorrowService implements CrudService<Borrow, BorrowCreateDTO> {
    //Injection de l'instance de BorrowRepository par contructeur via @RequiredArgsConstructor
    private final BorrowRepository borrowRepository;
    private final DTOBorrowMapper dtoBorrowMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @Override
    public List<Borrow> selectAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow selectById(long id) {
        return borrowRepository.findById(id).orElseThrow(() -> new BorrowNotFoundException(id));
    }

    @Override
    public void delete(long id) {
        if (!borrowRepository.existsById(id)) {
            throw new BorrowNotFoundException(id);

        }

        borrowRepository.deleteById(id);
    }

    @Override
    public Borrow save(BorrowCreateDTO dto) {

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new BookNotFoundException(dto.getBookId()));

        if (dto.getBorrowStart().isAfter(dto.getBorrowEnd())) {
            throw new IllegalArgumentException(
                    "La date de début ne peut pas être postérieure à la date de fin."
            );
        }

        boolean bookAlreadyBorrowed =
                borrowRepository.existsByBookIdAndReturnDateIsNull(dto.getBookId());

        if (bookAlreadyBorrowed) {
            throw new IllegalStateException("Ce livre est déjà emprunté actuellement.");
        }

        Reservation reservation =
                reservationService.getReservationByUserAndBookId(dto.getUserId(), dto.getBookId());

        if (book.isReserved() && reservation == null) {
            throw new IllegalStateException("Ce livre est réservé par un autre utilisateur.");
        }

        dto.setReturnDate(null);

        if (reservation != null) {
            reservationService.delete(reservation.getId());
        }

        Borrow borrow = borrowRepository.save(dtoBorrowMapper.toBorrow(dto));

        book.setStatus(AvailabilityStatus.BORROWED);
        book.setReserved(false);
        bookRepository.save(book);

        return borrow;
    }

    public Borrow updateReturnDate(long id, ReturnDateDTO dto) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new BorrowNotFoundException(id));

        if (dto.getReturnDate() != null &&
                dto.getReturnDate().isBefore(borrow.getBorrowStart())) {

            throw new IllegalArgumentException(
                    "La date de retour ne peut pas être antérieure à la date de début d'emprunt."
            );
        }

        borrow.setReturnDate(dto.getReturnDate());

        if (dto.getReturnDate() != null) {
            Book book = borrow.getBook();
            book.setStatus(AvailabilityStatus.AVAILABLE);
        }

        return borrowRepository.save(borrow);
    }

    public boolean existsById(long id) {
        return borrowRepository.findById(id).isPresent();
    }

    public List<Borrow> findByUserId(long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);

        }
        return borrowRepository.findAllByUserId(id);
    }

    public Borrow findByBookId(long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        return borrowRepository.findBorrowByBookId(id);
    }
}
