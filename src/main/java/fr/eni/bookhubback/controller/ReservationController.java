package fr.eni.bookhubback.controller;

import fr.eni.bookhubback.businessObject.DTO.ReservationDTO;
import fr.eni.bookhubback.businessObject.DTO.ReservationResponseDTO;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.mapper.DTOReservationMapper;
import fr.eni.bookhubback.service.ReservationService;
import fr.eni.bookhubback.service.UserService;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final DTOReservationMapper reservationMapper;

    @GetMapping("/api/reservations")
    public List<ReservationResponseDTO> getReservations() {
        return reservationService.selectAll()
                .stream()
                .map(reservationMapper::toReservationResponseDTO)
                .toList();
    }

    @GetMapping("/api/reservations/{id}")
    public ReservationResponseDTO getReservation(@PathVariable long id) {
        return reservationMapper.toReservationResponseDTO(
                reservationService.selectById(id)
        );
    }

    @GetMapping("/api/reservations/user/{id}")
    public List<ReservationResponseDTO> getUserReservations(@PathVariable Long id) {
        return reservationService.getUserReservations(id)
                .stream()
                .map(reservationMapper::toReservationResponseDTO)
                .toList();
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/reservations")
    public Reservation saveReservation(@RequestBody @Nonnull @Validated ReservationDTO reservationDto) {
        return reservationService.save(reservationDto);
    }
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/api/reservations/{id}")
    public void deleteReservation(@PathVariable long id) {
        reservationService.delete(id);
    }
}
