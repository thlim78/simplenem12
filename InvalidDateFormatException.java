package simplenem12;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message) {
        super(message);
    }
    public InvalidDateFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}