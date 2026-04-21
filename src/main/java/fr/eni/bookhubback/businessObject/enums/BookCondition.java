package fr.eni.bookhubback.businessObject.enums;

public enum BookCondition {
    PRISTINE("Pristine"),
    USED("Used"),
    POOR("Poor"),
    UNUSABLE("Unusable");

    public final String name;

    BookCondition(String name) {
        this.name = name;
    }
}
