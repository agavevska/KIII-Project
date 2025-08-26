package mk.ukim.finki.emc.roombookingbackend.service.domain;

import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User register(User user);

    User login(String username, String password);
    Optional<User> findByUsername(String username);
}
