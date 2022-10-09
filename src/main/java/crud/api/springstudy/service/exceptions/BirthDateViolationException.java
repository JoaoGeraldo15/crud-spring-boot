package crud.api.springstudy.service.exceptions;

public class BirthDateViolationException extends RuntimeException {
    public BirthDateViolationException(String message) {
        super(message);
    }
}
