package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class ReservationCanNotBeCanceledException extends RuntimeException {

    public ReservationCanNotBeCanceledException(Long id) {
        super(String.format("The reservation with ID %s cannot be canceled.", id));
    }

}
