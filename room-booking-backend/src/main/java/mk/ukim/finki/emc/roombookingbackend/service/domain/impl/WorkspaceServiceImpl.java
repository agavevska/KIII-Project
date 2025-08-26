package mk.ukim.finki.emc.roombookingbackend.service.domain.impl;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;
import mk.ukim.finki.emc.roombookingbackend.repository.WorkspaceRepository;
import mk.ukim.finki.emc.roombookingbackend.service.domain.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository) {
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public List<Workspace> findAll() {
        return workspaceRepository.findAll();
    }

    @Override
    public Optional<Workspace> findById(Long id) {
        return workspaceRepository.findById(id);
    }

    @Override
    public Workspace save(Workspace workspace) {
        return workspaceRepository.save(workspace);
    }

    @Override
    public Optional<Workspace> update(Long id, Workspace workspace) {
        return findById(id)
                .map((existingWorkspace) -> {
                    existingWorkspace.setName(workspace.getName());
                    existingWorkspace.setDescription(workspace.getDescription());
                    return workspaceRepository.save(existingWorkspace);
                });
    }

    @Override
    public Optional<Workspace> deleteById(Long id) {
        Optional<Workspace> workspace = findById(id);
        workspace.ifPresent(workspaceRepository::delete);
        return workspace;
    }

}
