package christmas.exception;

public class UnvalidDateException extends IllegalArgumentException {
    public UnvalidDateException(String message) {
        super(message);
    }

    public UnvalidDateException() {
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
