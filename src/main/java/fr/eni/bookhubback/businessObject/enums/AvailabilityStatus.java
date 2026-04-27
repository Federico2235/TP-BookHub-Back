package fr.eni.bookhubback.businessObject.enums;

public enum AvailabilityStatus {
    AVAILABLE("Available"),
    BORROWED("Borrowed"),
    BLOCKED("Blocked");

    public final String name;

    AvailabilityStatus(String name) {
        this.name = name;
    }
}
