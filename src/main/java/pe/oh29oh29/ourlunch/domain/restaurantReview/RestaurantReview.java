package pe.oh29oh29.ourlunch.domain.restaurantReview;

import lombok.*;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@Table(name = "restaurant_reviews")
public class RestaurantReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @NonNull
    private int starScore;

    private String comment;
}
