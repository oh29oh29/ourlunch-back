package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public void addRestaurant(final String familyName, final String restaurantName) {
        final Family family = familyRepository.findByName(familyName);
        final Restaurant restaurant = restaurantRepository.save(new Restaurant(family, restaurantName));
        final List<Restaurant> restaurantList = family.getRestaurant();

        restaurantList.add(restaurant);
        family.setRestaurant(restaurantList);
    }

}
