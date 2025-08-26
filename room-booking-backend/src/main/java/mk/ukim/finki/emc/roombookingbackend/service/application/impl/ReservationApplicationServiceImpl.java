package mk.ukim.finki.emc.roombookingbackend.service.application.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.service.application.ReservationApplicationService;
import mk.ukim.finki.emc.roombookingbackend.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationApplicationServiceImpl implements ReservationApplicationService {

    private final ReservationService reservationService;

    public ReservationApplicationServiceImpl(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public List<DisplayReservationDetailsDto> findAllByUserWithDetails(User user) {
        return DisplayReservationDetailsDto.from(reservationService.findAllByUser(user));
    }

    @Override
    public Optional<DisplayReservationDetailsDto> findByIdAndUserWithDetails(Long id, User user) {
        return reservationService
                .findByIdAndUser(id, user)
                .map(DisplayReservationDetailsDto::from);
    }

    @Override
    public Optional<DisplayReservationDto> startByIdAndUser(Long id, User user) {
        return reservationService.startByIdAndUser(id, user)
                .map(DisplayReservationDto::from);
    }

    @Override
    public Optional<DisplayReservationDto> endByIdAndUser(Long id, User user) {
        return reservationService.endByIdAndUser(id, user)
                .map(DisplayReservationDto::from);
    }

    @Override
    public Optional<DisplayReservationDto> cancelByIdAndUser(Long id, User user) {
        return reservationService.cancelByIdAndUser(id, user)
                .map(DisplayReservationDto::from);
    }

}
