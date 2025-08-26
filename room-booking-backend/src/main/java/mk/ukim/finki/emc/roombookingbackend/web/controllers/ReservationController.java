package mk.ukim.finki.emc.roombookingbackend.web.controllers;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDetailsDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayReservationDto;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.service.application.ReservationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reservations")
@RestController
public class ReservationController {

    private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {
        this.reservationApplicationService = reservationApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayReservationDetailsDto>> findAllByUserWithDetails(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(reservationApplicationService.findAllByUserWithDetails(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayReservationDetailsDto> findByIdAndUserWithDetails(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return reservationApplicationService
                .findByIdAndUserWithDetails(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<DisplayReservationDto> startByIdAndUser(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return reservationApplicationService.startByIdAndUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/end")
    public ResponseEntity<DisplayReservationDto> endByIdAndUser(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return reservationApplicationService.endByIdAndUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<DisplayReservationDto> cancelByIdAndUser(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        // TODO: Implement this.
        return reservationApplicationService.cancelByIdAndUser(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
