package fr.eni.bookhubback.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(Long id) {
        super("Erreur: Aucune réservation avec l'id %d n'a été trouvée".formatted(id));
    }
}
