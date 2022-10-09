package crud.api.springstudy.service.exceptions;

public class EmailNotValid extends RuntimeException {
    public EmailNotValid(String message) {
        super(message);
    }
}
