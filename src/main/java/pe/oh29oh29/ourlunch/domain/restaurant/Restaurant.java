package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.Data;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data

@Entity(name = "restaurants")
public class Restaurant {

    public Restaurant(
            @NotNull Family family,
            @NotNull String name
    ) {
        this.family = family;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Family family;

    @NotNull
    private String name;

    private String type;

    private String placeId;

    private String positionX;

    private String positionY;
}
