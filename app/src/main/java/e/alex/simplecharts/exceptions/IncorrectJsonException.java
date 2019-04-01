package e.alex.simplecharts.exceptions;

public class IncorrectJsonException extends Exception {
    public IncorrectJsonException() {
    }

    public IncorrectJsonException(String message) {
        super(message);
    }

    public IncorrectJsonException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
