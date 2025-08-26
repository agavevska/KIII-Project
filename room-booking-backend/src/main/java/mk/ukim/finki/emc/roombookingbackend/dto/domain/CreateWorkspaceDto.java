package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;

public record CreateWorkspaceDto(
        String name,
        String description
) {

    public Workspace toWorkspace() {
        return new Workspace(name, description);
    }

}
