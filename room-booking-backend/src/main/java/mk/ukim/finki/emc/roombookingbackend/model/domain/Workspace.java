package mk.ukim.finki.emc.roombookingbackend.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "workspace")
    private List<Room> rooms;

    public Workspace() {
    }

    public Workspace(String name, String description) {
        this.name = name;
        this.description = description;
        rooms = new ArrayList<>();
    }

}
