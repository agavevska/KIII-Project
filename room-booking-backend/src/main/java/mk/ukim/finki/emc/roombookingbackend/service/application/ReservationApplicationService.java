package mk.ukim.finki.emc.roombookingbackend.service.application;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface ReservationApplicationService {
    List<DisplayReservationDetailsDto> findAllByUserWithDetails(User user);

    Optional<DisplayReservationDetailsDto> findByIdAndUserWithDetails(Long id, User user);

    Optional<DisplayReservationDto> startByIdAndUser(Long id, User user);

    Optional<DisplayReservationDto> endByIdAndUser(Long id, User user);

    Optional<DisplayReservationDto> cancelByIdAndUser(Long id, User user);
}
