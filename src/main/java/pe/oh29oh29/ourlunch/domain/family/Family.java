package pe.oh29oh29.ourlunch.domain.family;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.oh29oh29.ourlunch.domain.company.Company;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity(name = "families")
public class Family {

    public Family(
            @NotNull Company company,
            @NotNull String name,
            @NotNull String linkUrl
    ) {
        this.company = company;
        this.name = name;
        this.linkUrl = linkUrl;
        this.createDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private Company company;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "family")
    private List<Restaurant> restaurant;

    @NotNull
    private String linkUrl;

    @NotNull
    private LocalDateTime createDate;

}
