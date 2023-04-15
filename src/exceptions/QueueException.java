package exceptions;

public class QueueException extends Exception {

    private String message;

    public QueueException(String message) {
        super(message);
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
