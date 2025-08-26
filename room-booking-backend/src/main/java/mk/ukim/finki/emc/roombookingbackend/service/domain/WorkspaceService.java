package mk.ukim.finki.emc.roombookingbackend.service.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;

import java.util.List;
import java.util.Optional;

public interface WorkspaceService {
    List<Workspace> findAll();

    Optional<Workspace> findById(Long id);

    Workspace save(Workspace workspace);

    Optional<Workspace> update(Long id, Workspace workspace);

    Optional<Workspace> deleteById(Long id);
}
