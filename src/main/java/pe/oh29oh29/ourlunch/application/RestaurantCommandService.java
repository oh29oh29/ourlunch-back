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
    public void addRestaurant(
            final String familyName,
            final String name,
            final String address,
            final String type,
            final String positionX,
            final String positionY
    ) {
        /**
         * TODO
         * 음식점 고유 ID 여부 확인 (ID가 있으면 중복 체크 로직 추가 필요)
         * */
        final Family family = familyRepository.findByName(familyName).orElseThrow(IllegalArgumentException::new);
        final Restaurant restaurant =
                restaurantRepository.save(
                        new Restaurant(
                                family,
                                name,
                                address,
                                type,
                                positionX,
                                positionY
                        )
                );
        final List<Restaurant> restaurantList = family.getRestaurant();

        restaurantList.add(restaurant);
        family.setRestaurant(restaurantList);
    }

}
