package exceptions;

public class NoSuchUserException  extends RuntimeException{
    public NoSuchUserException(String msg){
        super(msg);
    }
}
