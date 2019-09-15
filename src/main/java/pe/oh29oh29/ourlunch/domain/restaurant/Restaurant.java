package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.*;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "restaurants")
public class Restaurant {

    public static Restaurant of(final Family family,
                                final String name,
                                final String positionX,
                                final String positionY) {
        return new Restaurant(family, name, positionX, positionY);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Family family;

    @NonNull
    private String name;

    private String type;

    private String placeId;

    @NonNull
    private String positionX;

    @NonNull
    private String positionY;
}
