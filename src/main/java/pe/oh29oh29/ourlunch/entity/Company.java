package pe.oh29oh29.ourlunch.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "companies")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NonNull
    private String name;

    private long positionX;

    private long positionY;

}
