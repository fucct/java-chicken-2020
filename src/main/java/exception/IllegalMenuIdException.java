package exception;

public class IllegalMenuIdException extends RuntimeException {
    public IllegalMenuIdException(final String message) {
        super(message);
    }
}
