package mk.ukim.finki.emc.roombookingbackend.service.application;

import mk.ukim.finki.emc.roombookingbackend.dto.domain.LoginUserRequestDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.LoginUserResponseDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.RegisterUserRequestDto;
import mk.ukim.finki.emc.roombookingbackend.dto.domain.RegisterUserResponseDto;

import java.util.Optional;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
