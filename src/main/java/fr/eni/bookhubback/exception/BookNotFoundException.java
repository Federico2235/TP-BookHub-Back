package fr.eni.bookhubback.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
      super("Erreur: Aucun livre avec l'id %d n'a été trouvé".formatted(id));
    }
}
