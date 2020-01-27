package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity(name = "restaurants")
public class Restaurant {

    public Restaurant(
            @NotNull Family family,
            @NotNull String name,
            @NotNull String address,
            @NotNull String type,
            @NotNull String positionX,
            @NotNull String positionY
    ) {
        this.family = family;
        this.name = name;
        this.address = address;
        this.type = type;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Family family;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String type;

    private String placeId;

    @NotNull
    private String positionX;

    @NotNull
    private String positionY;
}
