package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;

public record CreateRoomDto(
        String code,
        Long workspaceId,
        Integer floor,
        Double price
) {

    public Room toRoom(Workspace workspace) {
        return new Room(code, workspace, floor, price);
    }

}
