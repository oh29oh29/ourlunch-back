package pe.oh29oh29.ourlunch.domain.family;

import lombok.*;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "families")
public class Family {

    public static Family of(final Company company,
                            final String name,
                            final String linkUrl) {
        return new Family(company, name, linkUrl, LocalDateTime.now());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NonNull
    private Company company;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "family")
    private List<Restaurant> restaurant;

    @NonNull
    private String linkUrl;

    @NonNull
    private LocalDateTime createDate;

}
