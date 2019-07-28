package pe.oh29oh29.ourlunch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "family_members")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class FamilyMember {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Family family;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Member member;

    @OneToMany
    private List<RestaurantReview> restaurantReview;

    @NonNull
    private String name;

    @NonNull
    private boolean isMaster;

    private String taste;

    @NonNull
    private String joinDate;
}
