package main.java.ru.clevertec.check.exception;

public class ApplicationException extends RuntimeException{

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException() {
    }
}
