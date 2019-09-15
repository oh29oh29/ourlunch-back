package pe.oh29oh29.ourlunch.domain.company;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
public class Company {

    private Company (final String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private long positionX;

    private long positionY;

    public static Company newInstance (final String name) {
        return new Company(name);
    }

}
