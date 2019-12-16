package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;
import pe.oh29oh29.ourlunch.domain.restaurant.RestaurantRepository;

import java.util.List;

@RequiredArgsConstructor

@Service
public class RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;
    private final FamilyRepository familyRepository;

    public void addRestaurant(final String familyName,
                       final String restaurantName,
                       final String positionX,
                       final String positionY) {

        Family family = familyRepository.findByName(familyName);
        Restaurant restaurant = restaurantRepository.save(Restaurant.of(family, restaurantName, positionX, positionY));
        List<Restaurant> restaurantList = family.getRestaurant();
        restaurantList.add(restaurant);
        family.setRestaurant(restaurantList);
    }

}
