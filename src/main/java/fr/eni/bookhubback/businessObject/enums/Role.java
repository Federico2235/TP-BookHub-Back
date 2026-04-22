package fr.eni.bookhubback.businessObject.enums;

public enum Role {
    MEMBER,
    LIBRARIAN,
    ADMIN;


    public String toAuthority() {
        return "ROLE_" + this.name();
    }
}