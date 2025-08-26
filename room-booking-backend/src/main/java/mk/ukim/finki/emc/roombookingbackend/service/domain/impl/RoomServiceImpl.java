package mk.ukim.finki.emc.roombookingbackend.service.domain.impl;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.RoomIsNotAvailableException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.RoomNotFoundException;
import mk.ukim.finki.emc.roombookingbackend.repository.RoomRepository;
import mk.ukim.finki.emc.roombookingbackend.repository.ReservationRepository;
import mk.ukim.finki.emc.roombookingbackend.service.domain.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomServiceImpl(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> findAllByAvailable(Boolean available) {
        if(available == null){
            return roomRepository.findAll();
        }
        return roomRepository.findAllByAvailable(available);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> update(Long id, Room room) {
        return findById(id)
                .map(existingRoom -> {
                    existingRoom.setCode(room.getCode());
                    existingRoom.setFloor(room.getFloor());
                    existingRoom.setWorkspace(room.getWorkspace());
                    existingRoom.setPrice(room.getPrice());
                    existingRoom.setAvailable(room.getAvailable());
                    return roomRepository.save(existingRoom);
        });
    }

    @Override
    public Optional<Room> deleteById(Long id) {
        Optional<Room> room = findById(id);
        roomRepository.deleteById(id);
        return room;
    }

    @Override
    public Reservation reserveByUser(Room room, User user) {
        if(!room.getAvailable()){
            throw new RoomIsNotAvailableException(room.getId());
        }
        Reservation reservation = new Reservation(user, room);
        room.reserve();
        return reservationRepository.save(reservation);
    }

}
