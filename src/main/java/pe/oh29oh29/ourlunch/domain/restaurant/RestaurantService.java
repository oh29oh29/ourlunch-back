package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.restaurant.dto.RequestDTO;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public void addRestaurant(RequestDTO.RestaurantCreationRequest request) {

        Family family = new Family();
        family.setId(request.getFamilyId());

        Restaurant restaurant = new Restaurant(family, request.getName(), request.getType(), request.getPlaceId());

        restaurantRepository.save(restaurant);
    }

}
