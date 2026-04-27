package fr.eni.bookhubback.mapper;


import fr.eni.bookhubback.businessObject.DTO.BorrowCreateDTO;
import fr.eni.bookhubback.businessObject.DTO.BorrowResponseDTO;
import fr.eni.bookhubback.businessObject.DTO.UserResponseDTO;
import fr.eni.bookhubback.businessObject.entity.Book;
import fr.eni.bookhubback.businessObject.entity.Borrow;
import fr.eni.bookhubback.businessObject.entity.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DTOBorrowMapper {

    private final EntityManager entityManager;

    public BorrowResponseDTO toResponseDTO(Borrow borrow) {
        BorrowResponseDTO borrowResponseDTO = new BorrowResponseDTO();
        borrowResponseDTO.setBorrowId(borrow.getBorrowId());
        borrowResponseDTO.setBook(borrow.getBook());
        borrowResponseDTO.setUser(mapUser(borrow.getUser()));
        borrowResponseDTO.setBorrowStart(borrow.getBorrowStart());
        borrowResponseDTO.setBorrowEnd(borrow.getBorrowEnd());
        borrowResponseDTO.setReturnDate(borrow.getReturnDate());

        return borrowResponseDTO;
    }

    private UserResponseDTO mapUser(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    //Convertit un BorrowDTO en une instance de Borrow en utilisant un constructeur vide + setters
    public Borrow toBorrow(BorrowCreateDTO borrowCreateDTO) {
        //Récupère la Category grâce à la categoryId présente dans le BorrowDTO
        User user  = entityManager.getReference(User.class, borrowCreateDTO.getUserId());
        Book book  = entityManager.getReference(Book.class, borrowCreateDTO.getBookId());
        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowStart(borrowCreateDTO.getBorrowStart());
        borrow.setBorrowEnd(borrowCreateDTO.getBorrowEnd());
        borrow.setReturnDate(borrowCreateDTO.getReturnDate());

       return borrow;
    }
}
