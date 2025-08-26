package mk.ukim.finki.emc.roombookingbackend.service.domain.impl;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.model.enums.ReservationStatus;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeEndedException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeStartedException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.ReservationCanNotBeCanceledException;
import mk.ukim.finki.emc.roombookingbackend.repository.RoomRepository;
import mk.ukim.finki.emc.roombookingbackend.repository.ReservationRepository;
import mk.ukim.finki.emc.roombookingbackend.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Reservation> findAllByUser(User user) {
        return reservationRepository.findAllByUser(user);
    }

    @Override
    public Optional<Reservation> findByIdAndUser(Long id, User user) {
        return reservationRepository.findByIdAndUser(id, user);
    }

    @Override
    public Optional<Reservation> startByIdAndUser(Long id, User user) {
        Optional<Reservation> reservation = reservationRepository.findByIdAndUser(id, user);

        if(reservation.get().getStatus().equals(ReservationStatus.ACTIVE) ||
                reservation.get().getStatus().equals(ReservationStatus.COMPLETED) ||
                reservation.get().getStatus().equals(ReservationStatus.CANCELED))
        {
            throw new ReservationCanNotBeStartedException(id);
        }
        reservation.get().start();
        reservationRepository.save(reservation.get());
        return reservation;
    }

    @Override
    public Optional<Reservation> endByIdAndUser(Long id, User user) {
        Optional<Reservation> reservation = findByIdAndUser(id, user);


        if (reservation.get().getStatus().equals(ReservationStatus.RESERVED) ||
                reservation.get().getStatus().equals(ReservationStatus.COMPLETED) ||
                reservation.get().getStatus().equals(ReservationStatus.CANCELED)) {
            throw new ReservationCanNotBeEndedException(id);
        }
        reservation.get().end();
        reservation.get().getRoom().setAvailable(true);
        reservationRepository.save(reservation.get());

        return reservation;
    }

    @Override
    public Optional<Reservation> cancelByIdAndUser(Long id, User user) {
        Optional<Reservation> reservation = findByIdAndUser(id, user);

        if (reservation.get().getStatus().equals(ReservationStatus.ACTIVE) ||
                reservation.get().getStatus().equals(ReservationStatus.COMPLETED) ||
                reservation.get().getStatus().equals(ReservationStatus.CANCELED)) {
            throw new ReservationCanNotBeEndedException(id);
        }
        reservation.get().cancel();
        reservation.get().getRoom().setAvailable(true);
        reservationRepository.save(reservation.get());

        return reservation;
    }

}
