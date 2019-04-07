package Exceptions;

public class CellNotFoundException extends Exception {
    public CellNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
