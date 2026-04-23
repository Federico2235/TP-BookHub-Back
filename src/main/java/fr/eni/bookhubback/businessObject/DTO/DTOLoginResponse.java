package fr.eni.bookhubback.businessObject.DTO;

public class DTOLoginResponse {
    private String token;
    private String message;
    private Long id;

    public DTOLoginResponse(String token, String message,Long id) {
        this.token = token;
        this.message = message;
        this.id=id;
    }

    public String getToken() { return token; }
    public String getMessage() { return message; }
    public Long getId(){return  id;}
}