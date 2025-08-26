package mk.ukim.finki.emc.roombookingbackend.service.application.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateRoomDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Reservation;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.RoomNotFoundException;
import mk.ukim.finki.emc.roombookingbackend.model.exceptions.WorkspaceNotFoundException;
import mk.ukim.finki.emc.roombookingbackend.service.application.RoomApplicationService;
import mk.ukim.finki.emc.roombookingbackend.service.domain.RoomService;
import mk.ukim.finki.emc.roombookingbackend.service.domain.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomApplicationServiceImpl implements RoomApplicationService {

    private final RoomService roomService;
    private final WorkspaceService workspaceService;

    public RoomApplicationServiceImpl(
            RoomService roomService,
            WorkspaceService workspaceService
    ) {
        this.roomService = roomService;
        this.workspaceService = workspaceService;
    }

    @Override
    public List<DisplayRoomDto> findAll() {
        return DisplayRoomDto.from(roomService.findAll());
    }

    @Override
    public List<DisplayRoomDto> findAllByAvailable(Boolean available) {
        return DisplayRoomDto.from(roomService.findAllByAvailable(available));
    }

    @Override
    public Optional<DisplayRoomDto> findById(Long id) {
        return roomService
                .findById(id)
                .map(DisplayRoomDto::from);
    }

    @Override
    public Optional<DisplayRoomDetailsDto> findByIdWithDetails(Long id) {
        return roomService.findById(id)
                .map(DisplayRoomDetailsDto::from);
    }

    @Override
    public DisplayRoomDto save(CreateRoomDto createRoomDto) {
        Workspace w = workspaceService.findById(createRoomDto.workspaceId())
                .orElseThrow(() -> new WorkspaceNotFoundException(createRoomDto.workspaceId()));

        return DisplayRoomDto.from(roomService.save(createRoomDto.toRoom(w)));
    }

    @Override
    public Optional<DisplayRoomDto> update(Long id, CreateRoomDto createRoomDto) {
        Workspace w = workspaceService.findById(createRoomDto.workspaceId())
                .orElseThrow(() -> new WorkspaceNotFoundException(createRoomDto.workspaceId()));

        return roomService.update(id, createRoomDto.toRoom(w))
                .map(DisplayRoomDto::from);
    }

    @Override
    public Optional<DisplayRoomDto> deleteById(Long id) {
        return roomService.deleteById(id).map(DisplayRoomDto::from);
    }

    @Override
    public Reservation reserveByIdAndUser(Long id, User user) {
        Room r = roomService.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        return roomService.reserveByUser(r, user);
    }

}
