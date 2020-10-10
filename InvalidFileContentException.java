package simplenem12;

public class InvalidFileContentException extends RuntimeException {
    public InvalidFileContentException(String message) {
        super(message);
    }
    public InvalidFileContentException(String message, Throwable cause) {
        super(message, cause);
    }
}