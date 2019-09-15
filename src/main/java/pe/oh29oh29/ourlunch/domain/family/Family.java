package pe.oh29oh29.ourlunch.domain.family;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "families")
@Data
@NoArgsConstructor
public class Family {

    private Family(final Company company,
                   final String name,
                   final String linkUrl) {
        this.company = company;
        this.name = name;
        this.linkUrl = linkUrl;
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

    public static Family newInstance(final Company company,
                                     final String name,
                                     final String linkUrl) {
        return new Family(company, name, linkUrl);
    }

}
