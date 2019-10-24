package exceptions;

public class PasswordInvalidException extends RuntimeException{
    public PasswordInvalidException(String msg){
        super(msg);
    }
}
