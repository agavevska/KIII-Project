package mk.ukim.finki.emc.roombookingbackend.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @ManyToOne
    private Workspace workspace;

    private Integer floor;

    private Double price;

    private Boolean available;

    public Room() {
    }

    public Room(String code, Workspace workspace, Integer floor, Double price) {
        this.code = code;
        this.workspace = workspace;
        this.floor = floor;
        this.price = price;
        available = true;
    }

    public void reserve() {
        available = false;
    }

    public void free() {
        available = true;
    }

}
