package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.ReservationDTO;
import fr.eni.bookhubback.businessObject.entity.Reservation;
import fr.eni.bookhubback.businessObject.entity.User;
import fr.eni.bookhubback.exception.ReservationNotFoundException;
import fr.eni.bookhubback.mapper.DTOReservationMapper;
import fr.eni.bookhubback.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements CrudService<Reservation, ReservationDTO> {

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
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation save(ReservationDTO reservationDTO) {
        return reservationRepository.save(mapper.toReservation(reservationDTO));
    }
}
