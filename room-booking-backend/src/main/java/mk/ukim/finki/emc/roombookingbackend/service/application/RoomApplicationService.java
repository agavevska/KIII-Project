package mk.ukim.finki.emc.roombookingbackend.service.application;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateRoomDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface RoomApplicationService {
    List<DisplayRoomDto> findAll();

    List<DisplayRoomDto> findAllByAvailable(Boolean available);

    Optional<DisplayRoomDto> findById(Long id);

    Optional<DisplayRoomDetailsDto> findByIdWithDetails(Long id);

    DisplayRoomDto save(CreateRoomDto createRoomDto);

    Optional<DisplayRoomDto> update(Long id, CreateRoomDto createRoomDto);

    Optional<DisplayRoomDto> deleteById(Long id);

    Reservation reserveByIdAndUser(Long id, User user);
}
