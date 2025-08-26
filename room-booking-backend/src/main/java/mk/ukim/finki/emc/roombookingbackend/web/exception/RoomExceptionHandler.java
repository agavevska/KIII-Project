package mk.ukim.finki.emc.roombookingbackend.web.exception;

import io.swagger.v3.oas.annotations.Hidden;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.RoomIsNotAvailableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class RoomExceptionHandler {

    @ExceptionHandler(RoomIsNotAvailableException.class)
    public ResponseEntity<String> handleRoomIsNotAvailableException(RoomIsNotAvailableException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
