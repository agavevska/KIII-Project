package mk.ukim.finki.emc.roombookingbackend.dto.domain;

public record LoginUserRequestDto(
        String username,
        String password
) {
}
