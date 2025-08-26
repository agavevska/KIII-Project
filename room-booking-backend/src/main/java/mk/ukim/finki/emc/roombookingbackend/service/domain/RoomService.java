package mk.ukim.finki.emc.roombookingbackend.service.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> findAll();

    List<Room> findAllByAvailable(Boolean available);

    Optional<Room> findById(Long id);

    Room save(Room room);

    Optional<Room> update(Long id, Room room);

    Optional<Room> deleteById(Long id);

    Reservation reserveByUser(Room room, User user);
}
