package fr.eni.bookhubback.service;



import fr.eni.bookhubback.businessObject.DTO.BorrowCreateDTO;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.exception.BookNotFoundException;
import fr.eni.bookhubback.exception.BorrowNotFoundException;
import fr.eni.bookhubback.mapper.DTOBorrowMapper;
import fr.eni.bookhubback.repository.BorrowRepository;
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
    public Borrow save(BorrowCreateDTO borrowCreateDTO) {

        if (borrowCreateDTO.getBorrowStart().isAfter(borrowCreateDTO.getBorrowEnd())) {
            throw new IllegalArgumentException("La date de début ne peut pas être postérieure à la date de fin.");
        }
        boolean bookAlreadyBorrowed =
                borrowRepository.existsByBookIdAndReturnDateIsNull(borrowCreateDTO.getBookId());

        if (bookAlreadyBorrowed) {
            throw new IllegalStateException("Ce livre est déjà emprunté actuellement.");
        }

        borrowCreateDTO.setReturnDate(null);

        return borrowRepository.save(dtoBorrowMapper.toBorrow(borrowCreateDTO));
    }

    public boolean existsById(long id) {
        return borrowRepository.findById(id).isPresent();
    }
}
