package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;

import java.util.List;

public record DisplayWorkspaceDto(
        Long id,
        String name,
        String description
) {

    public static DisplayWorkspaceDto from(Workspace workspace) {
        return new DisplayWorkspaceDto(
                workspace.getId(),
                workspace.getName(),
                workspace.getDescription()
        );
    }

    public static List<DisplayWorkspaceDto> from(List<Workspace> workspaces) {
        return workspaces
                .stream()
                .map(DisplayWorkspaceDto::from)
                .toList();
    }

}
