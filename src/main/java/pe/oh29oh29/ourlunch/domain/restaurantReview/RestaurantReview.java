package pe.oh29oh29.ourlunch.domain.restaurantReview;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)

@Entity(name = "restaurant_reviews")
public class RestaurantReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    @NotNull
    private int starScore;

    private String comment;
}
