package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;

import java.util.List;

public record DisplayRoomDto(
        Long id,
        String code,
        Long workspaceId,
        Integer floor,
        Double price,
        Boolean available
) {

    public static DisplayRoomDto from(Room room) {
        return new DisplayRoomDto(
                room.getId(),
                room.getCode(),
                room.getWorkspace().getId(),
                room.getFloor(),
                room.getPrice(),
                room.getAvailable()
        );
    }

    public static List<DisplayRoomDto> from(List<Room> rooms) {
        return rooms
                .stream()
                .map(DisplayRoomDto::from)
                .toList();
    }

}
