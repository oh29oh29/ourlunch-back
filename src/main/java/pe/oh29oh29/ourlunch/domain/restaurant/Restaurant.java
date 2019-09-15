package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Family family;

    @NonNull
    private String name;

    //@NonNull
    private String type;

    //@NonNull
    private String placeId;

    private String positionX;

    private String positionY;

    public Restaurant(@NonNull Family family, @NonNull String name, String positionX, String positionY) {
        this.family = family;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static Restaurant newInstance(final Family family,
                                         final String name,
                                         final String positionX,
                                         final String positionY) {
        return new Restaurant(family, name, positionX, positionY);
    }
}
