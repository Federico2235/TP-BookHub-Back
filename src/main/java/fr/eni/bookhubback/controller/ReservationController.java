package fr.eni.bookhubback.controller;

import fr.eni.bookhubback.businessObject.DTO.ReservationDTO;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.service.ReservationService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/api/reservations")
    public List<Reservation> getReservations() {
        return reservationService.selectAll();
    }

    @GetMapping("/api/reservations/{id}")
    public Reservation getReservation(@PathVariable long id) {
        return reservationService.selectById(id);
    }

    @GetMapping("/api/reservations/user/{id}")
    public List<Reservation> getUserReservations(@PathVariable Long id) {
        return this.reservationService.getUserReservations(id);
    }

    @PostMapping("/api/reservations")
    public Reservation saveReservation(@RequestBody @Nonnull @Validated ReservationDTO reservationDto) {
        return reservationService.save(reservationDto);
    }

    @DeleteMapping("/api/reservations/{id}")
    public void deleteReservation(@PathVariable long id) {
        reservationService.delete(id);
    }
}
