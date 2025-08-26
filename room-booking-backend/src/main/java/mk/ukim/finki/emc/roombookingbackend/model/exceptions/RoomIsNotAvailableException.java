package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class RoomIsNotAvailableException extends RuntimeException {

    public RoomIsNotAvailableException(Long id) {
        super(String.format("The room with ID %s is not available.", id));
    }

}
