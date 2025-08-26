package mk.ukim.finki.emc.roombookingbackend.service.application;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateWorkspaceDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayWorkspaceDto;

import java.util.List;
import java.util.Optional;

public interface WorkspaceApplicationService {
    List<DisplayWorkspaceDto> findAll();

    Optional<DisplayWorkspaceDto> findById(Long id);

    DisplayWorkspaceDto save(CreateWorkspaceDto createWorkspaceDto);

    Optional<DisplayWorkspaceDto> update(Long id, CreateWorkspaceDto createWorkspaceDto);

    Optional<DisplayWorkspaceDto> deleteById(Long id);
}
