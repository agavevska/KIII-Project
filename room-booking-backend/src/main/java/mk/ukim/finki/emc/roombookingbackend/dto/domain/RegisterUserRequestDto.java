package mk.ukim.finki.emc.roombookingbackend.dto.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.User;

public record RegisterUserRequestDto(
        String username,
        String password,
        String name,
        String surname,
        String email
) {

    public User toUser() {
        return new User(username, password, name, surname, email);
    }

}
