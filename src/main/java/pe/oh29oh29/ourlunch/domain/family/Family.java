package pe.oh29oh29.ourlunch.domain.family;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pe.oh29oh29.ourlunch.entity.Company;
import pe.oh29oh29.ourlunch.entity.Restaurant;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "families")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Family {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

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
