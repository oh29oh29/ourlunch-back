package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pe.oh29oh29.ourlunch.domain.family.Family;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
@Data
@RequiredArgsConstructor
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

    @NonNull
    private String type;

    @NonNull
    private String placeId;

    private String positionX;

    private String positionY;

}
