package fr.eni.bookhubback.service;

import fr.eni.bookhubback.businessObject.DTO.UserDTO;
import fr.eni.bookhubback.businessObject.entity.User;

import java.util.List;

/**
 * Interface générique représentant un service capable de faire un CRUD
 **/
public interface CrudService <T, U> {
    List<T> selectAll();
    T selectById(long id);
    void delete(long id);
    T save(U u);
}
