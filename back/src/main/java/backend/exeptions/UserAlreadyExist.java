package backend.exeptions;

public class UserAlreadyExist extends Exception{
    public UserAlreadyExist(String message) {
        super(message);
    }
}
