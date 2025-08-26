package mk.ukim.finki.emc.roombookingbackend.repository;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findTopByOrderByIdDesc();
    List<Room> findAllByAvailable(Boolean available);
}
