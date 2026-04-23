package fr.eni.bookhubback.exception;

public class UseByMailNotFoundException extends RuntimeException {
    public UseByMailNotFoundException(String email) {
      super("Erreur: Aucun utilisateur avec cette email n'a été trouvé");
    }
}
