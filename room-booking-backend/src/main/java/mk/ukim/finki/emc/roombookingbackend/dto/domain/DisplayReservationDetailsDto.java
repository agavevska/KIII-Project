package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.List;

public record DisplayReservationDetailsDto(
        Long id,
        DisplayRoomDetailsDto room,
        LocalDateTime startTime,
        LocalDateTime endTime,
        ReservationStatus status
) {

    public static DisplayReservationDetailsDto from(Reservation reservation) {
        return new DisplayReservationDetailsDto(
                reservation.getId(),
                DisplayRoomDetailsDto.from(reservation.getRoom()),
                reservation.getStartTime(),
                reservation.getEndTime(),
                reservation.getStatus()
        );
    }

    public static List<DisplayReservationDetailsDto> from(List<Reservation> reservations) {
        return reservations
                .stream()
                .map(DisplayReservationDetailsDto::from)
                .toList();
    }

}
