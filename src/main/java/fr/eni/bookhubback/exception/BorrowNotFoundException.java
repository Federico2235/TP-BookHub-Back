package fr.eni.bookhubback.exception;

public class BorrowNotFoundException extends RuntimeException {
    public BorrowNotFoundException(long id) {
      super("Erreur: Aucun emprunt avec l'id %d n'a été trouvé".formatted(id));
    }
}
