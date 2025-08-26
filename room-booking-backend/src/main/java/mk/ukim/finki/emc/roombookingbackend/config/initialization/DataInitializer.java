package mk.ukim.finki.emc.roombookingbackend.config.initialization;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Room;
import mk.ukim.finki.emc.roombookingbackend.model.domain.Workspace;
import mk.ukim.finki.emc.roombookingbackend.model.domain.User;
import mk.ukim.finki.emc.roombookingbackend.model.enums.Role;
import mk.ukim.finki.emc.roombookingbackend.repository.RoomRepository;
import mk.ukim.finki.emc.roombookingbackend.repository.WorkspaceRepository;
import mk.ukim.finki.emc.roombookingbackend.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataInitializer {

    private final WorkspaceRepository workspaceRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            WorkspaceRepository workspaceRepository,
            RoomRepository roomRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.workspaceRepository = workspaceRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        userRepository.save(new User(
                "customer",
                passwordEncoder.encode("customer"),
                "customer",
                "customer",
                "customer@email.com",
                Role.ROLE_CUSTOMER
        ));

        userRepository.save(new User(
                "owner",
                passwordEncoder.encode("owner"),
                "owner",
                "owner",
                "owner@email.com",
                Role.ROLE_OWNER
        ));

        userRepository.save(new User(
                "admin",
                passwordEncoder.encode("admin"),
                "admin",
                "admin",
                "admin@email.com",
                Role.ROLE_ADMIN
        ));

        String[] names = {"Downtown Hub", "Tech Loft", "Creative Space", "Executive Lounge", "Startup Garage"};
        String[] descriptions = {
                "A central workspace with city views.",
                "Modern workspace for tech teams.",
                "Inspiring space for creatives.",
                "Premium offices for executives.",
                "Open space ideal for startups."
        };

        int[][] floors = {
                {1, 2, 3},
                {1, 1, 2},
                {2, 2, 3},
                {1, 3, 3},
                {1, 2, 2}
        };

        double[][] prices = {
                {60.0, 65.0, 70.0},
                {55.0, 55.0, 60.0},
                {50.0, 52.0, 54.0},
                {75.0, 80.0, 85.0},
                {45.0, 47.0, 49.0}
        };

        for (int i = 0; i < names.length; i++) {
            Workspace workspace = new Workspace(names[i], descriptions[i]);
            workspaceRepository.save(workspace);

            for (int j = 0; j < 3; j++) {
                String roomCode = names[i].substring(0, 3).toUpperCase() + "-R" + (j + 1);
                int floor = floors[i][j];
                double price = prices[i][j];

                Room room = new Room(roomCode, workspace, floor, price);
                roomRepository.save(room);
            }
        }
    }

}
