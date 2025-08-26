package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Long id) {
        super(String.format("The room with ID %s does not exist.", id));
    }

}
