package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.ReservationDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.businessObject.enums.AvailabilityStatus;
import fr.eni.bookhubback.exception.BookNotFoundException;
import fr.eni.bookhubback.exception.ReservationNotFoundException;
import fr.eni.bookhubback.mapper.DTOReservationMapper;
import fr.eni.bookhubback.repository.BookRepository;
import fr.eni.bookhubback.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements CrudService<Reservation, ReservationDTO> {

    private final BookRepository bookRepository;
    private final ReservationRepository reservationRepository;
    private final DTOReservationMapper mapper;

    @Override
    public List<Reservation> selectAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation selectById(long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    public List<Reservation> getUserReservations(long userId) {
        return reservationRepository.findAllByUserId(userId);
    }

    @Override
    public void delete(long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        Book book = reservation.getBook();

        reservationRepository.delete(reservation);

        book.setReserved(false);
        bookRepository.save(book);
    }

    @Override
    public Reservation save(ReservationDTO reservationDTO) {
        Book book = bookRepository.findById(reservationDTO.bookId())
                .orElseThrow(() -> new BookNotFoundException(reservationDTO.bookId()));

        if (book.isReserved()) {
            throw new IllegalStateException("Ce livre est déjà reservé actuellement.");
        }

         Reservation reservation =reservationRepository.save(mapper.toReservation(reservationDTO));

        book.setReserved(true);
        bookRepository.save(book);

        return reservation;
    }

    public Reservation getReservationByUserAndBookId(long userId, long bookId) {
       return reservationRepository.findByUserIdAndBookId(userId, bookId);
    }
}
