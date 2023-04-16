package exceptions;

public class HashException extends Exception {
    private String message;

    public HashException(String message) {
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
