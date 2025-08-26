package mk.ukim.finki.emc.roombookingbackend.service.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAllByUser(User user);

    Optional<Reservation> findByIdAndUser(Long id, User user);

    Optional<Reservation> startByIdAndUser(Long id, User user);

    Optional<Reservation> endByIdAndUser(Long id, User user);

    Optional<Reservation> cancelByIdAndUser(Long id, User user);
}
