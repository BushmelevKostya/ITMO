package common.exception;

public class NoAuthorizedException extends Exception{
    public NoAuthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
