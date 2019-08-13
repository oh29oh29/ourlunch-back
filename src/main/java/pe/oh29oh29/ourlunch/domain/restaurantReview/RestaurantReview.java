package pe.oh29oh29.ourlunch.domain.restaurantReview;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

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

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @NonNull
    private int starScore;

    @NonNull
    private String comment;
}
