package pe.oh29oh29.ourlunch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restaurants")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
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
