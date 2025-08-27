package mk.ukim.finki.emc.roombookingbackend.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emc.roombookingbackend.model.enums.ReservationStatus;

import java.time.LocalDateTime;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Room room;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation() {
    }

    public Reservation(User user, Room room) {
        this.user = user;
        this.room = room;
        this.status = ReservationStatus.RESERVED;
    }

    public void start() {
        startTime = LocalDateTime.now();
        status = ReservationStatus.ACTIVE;
    }

    public void end() {
        endTime = LocalDateTime.now();
        status = ReservationStatus.COMPLETED;
    }

    public void cancel() {
        status = ReservationStatus.CANCELED;
    }

}
