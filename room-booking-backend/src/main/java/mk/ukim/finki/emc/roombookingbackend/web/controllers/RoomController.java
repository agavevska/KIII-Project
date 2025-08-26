package mk.ukim.finki.emc.roombookingbackend.web.controllers;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateRoomDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayRoomDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.service.application.RoomApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rooms")
@RestController
public class RoomController {

    private final RoomApplicationService roomApplicationService;

    public RoomController(RoomApplicationService roomApplicationService) {
        this.roomApplicationService = roomApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayRoomDto>> findAll(@RequestParam(required = false) Boolean available) {
        return ResponseEntity.ok(roomApplicationService.findAllByAvailable(available));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayRoomDto> findById(@PathVariable Long id) {
        return roomApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<DisplayRoomDetailsDto> findByIdWithDetails(@PathVariable Long id) {
        return roomApplicationService
                .findByIdWithDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/add")
    public ResponseEntity<DisplayRoomDto> save(@RequestBody CreateRoomDto createRoomDto) {
        return ResponseEntity.ok(roomApplicationService.save(createRoomDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayRoomDto> update(@PathVariable Long id, @RequestBody CreateRoomDto createRoomDto) {
        // TODO: Implement this.
        return roomApplicationService.update(id, createRoomDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayRoomDto> deleteById(@PathVariable Long id) {
        // TODO: Implement this.
        return roomApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<DisplayReservationDto> reserveByIdAndUser(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(DisplayReservationDto.from(roomApplicationService.reserveByIdAndUser(id, user)));
    }

}
