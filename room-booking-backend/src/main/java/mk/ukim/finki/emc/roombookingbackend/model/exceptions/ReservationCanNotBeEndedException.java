package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class ReservationCanNotBeEndedException extends RuntimeException {

    public ReservationCanNotBeEndedException(Long id) {
        super(String.format("The reservation with ID %s cannot be ended.", id));
    }

}
