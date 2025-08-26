package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException() {
        super("The password is incorrect.");
    }

}
