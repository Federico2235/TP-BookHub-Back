package fr.eni.bookhubback.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
      super("Erreur: Aucun utilisateur avec l'id %d n'a été trouvé".formatted(id));
    }
}
