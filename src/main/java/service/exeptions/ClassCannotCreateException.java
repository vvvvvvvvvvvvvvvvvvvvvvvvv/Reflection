package service.exeptions;

public class ClassCannotCreateException extends RuntimeException {
    public ClassCannotCreateException(){

    }
    public ClassCannotCreateException(String message){
        super(message);
    }
}
