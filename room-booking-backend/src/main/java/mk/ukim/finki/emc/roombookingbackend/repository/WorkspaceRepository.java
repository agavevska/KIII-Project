package mk.ukim.finki.emc.roombookingbackend.repository;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
}
