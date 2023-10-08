package ex202_contract;

public class ConnectiveException extends RuntimeException {
    public ConnectiveException() {
    }

    public ConnectiveException(String message) {
        super(message);
    }

    public ConnectiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
