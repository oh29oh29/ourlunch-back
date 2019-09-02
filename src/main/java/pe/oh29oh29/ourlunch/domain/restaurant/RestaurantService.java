package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FamilyRepository familyRepository;

    void addRestaurant(final String familyName,
                       final String restaurantName,
                       final String positionX,
                       final String positionY) {

        Family family = familyRepository.findByName(familyName);
        Restaurant restaurant = restaurantRepository.save(Restaurant.newInstance(family, restaurantName, positionX, positionY));
        List<Restaurant> restaurantList = family.getRestaurant();
        restaurantList.add(restaurant);
        family.setRestaurant(restaurantList);
    }

}
