package exceptions;

public class StackException extends Exception {

    private String message;

    public StackException(String message) {
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}