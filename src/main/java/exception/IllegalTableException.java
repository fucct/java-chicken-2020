package exception;

public class IllegalTableException extends RuntimeException {
    public IllegalTableException(final String message) {
        super(message);
    }
}
