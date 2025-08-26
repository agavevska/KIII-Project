package mk.ukim.finki.emc.roombookingbackend.model.exceptions;

public class ReservationCanNotBeStartedException extends RuntimeException {

    public ReservationCanNotBeStartedException(Long id) {
        super(String.format("The reservation with ID %s cannot be started.", id));
    }

}
