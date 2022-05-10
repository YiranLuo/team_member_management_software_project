package exception.exer;

public class NegativeException extends RuntimeException{
    public NegativeException(String message) {
        super(message);
    }

    public NegativeException() {
    }
}
