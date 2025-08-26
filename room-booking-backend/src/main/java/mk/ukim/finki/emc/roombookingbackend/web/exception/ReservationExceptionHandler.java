package mk.ukim.finki.emc.roombookingbackend.web.exception;

import io.swagger.v3.oas.annotations.Hidden;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeCanceledException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeEndedException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeStartedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class ReservationExceptionHandler {

    @ExceptionHandler(ReservationCanNotBeStartedException.class)
    public ResponseEntity<String> handleReservationCanNotBeStartedException(ReservationCanNotBeStartedException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(ReservationCanNotBeEndedException.class)
    public ResponseEntity<String> handleReservationCanNotBeEndedException(ReservationCanNotBeEndedException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(ReservationCanNotBeCanceledException.class)
    public ResponseEntity<String> handleReservationCanNotBeCanceledException(ReservationCanNotBeCanceledException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
