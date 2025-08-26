package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.enums.ReservationStatus;

import java.time.LocalDateTime;

public record DisplayReservationDto(
        Long id,
        String username,
        Long roomId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        ReservationStatus status
) {

    public static DisplayReservationDto from(Reservation reservation) {
        return new DisplayReservationDto(
                reservation.getId(),
                reservation.getUser().getUsername(),
                reservation.getRoom().getId(),
                reservation.getStartTime(),
                reservation.getEndTime(),
                reservation.getStatus()
        );
    }

}
