package pe.oh29oh29.ourlunch.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_reviews")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RestaurantReview {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private FamilyMember familyMember;

    @NonNull
    private int starScore;

    @NonNull
    private String comment;
}
