package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayRoomDetailsDto(
        Long id,
        String code,
        DisplayWorkspaceDto workspace,
        Integer floor,
        Double price,
        Boolean available
) {

    public static DisplayRoomDetailsDto from(Room room) {
        return new DisplayRoomDetailsDto(
                room.getId(),
                room.getCode(),
                DisplayWorkspaceDto.from(room.getWorkspace()),
                room.getFloor(),
                room.getPrice(),
                room.getAvailable()
        );
    }

    public static List<DisplayRoomDetailsDto> from(List<Room> rooms) {
        return rooms.stream().map(DisplayRoomDetailsDto::from).collect(Collectors.toList());
    }

}
