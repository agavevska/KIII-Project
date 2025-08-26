package mk.ukim.finki.emc.roombookingbackend.service.application.impl;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.CreateWorkspaceDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.DisplayWorkspaceDto;
import mk.ukim.finki.emc.roombookingbackend.service.application.WorkspaceApplicationService;
import mk.ukim.finki.emc.roombookingbackend.service.domain.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceApplicationServiceImpl implements WorkspaceApplicationService {

    private final WorkspaceService workspaceService;

    public WorkspaceApplicationServiceImpl(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @Override
    public List<DisplayWorkspaceDto> findAll() {
        return DisplayWorkspaceDto.from(workspaceService.findAll());
    }

    @Override
    public Optional<DisplayWorkspaceDto> findById(Long id) {
        return workspaceService
                .findById(id)
                .map(DisplayWorkspaceDto::from);
    }

    @Override
    public DisplayWorkspaceDto save(CreateWorkspaceDto createWorkspaceDto) {
        return DisplayWorkspaceDto.from(workspaceService.save(createWorkspaceDto.toWorkspace()));
    }

    @Override
    public Optional<DisplayWorkspaceDto> update(Long id, CreateWorkspaceDto createWorkspaceDto) {
        return workspaceService
                .update(id, createWorkspaceDto.toWorkspace())
                .map(DisplayWorkspaceDto::from);
    }

    @Override
    public Optional<DisplayWorkspaceDto> deleteById(Long id) {
        return workspaceService
                .deleteById(id)
                .map(DisplayWorkspaceDto::from);
    }

}
