package fr.eni.bookhubback.mapper;

public class DTOLoginResponse {
    private String token;
    private String message;

    public DTOLoginResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() { return token; }
    public String getMessage() { return message; }
}