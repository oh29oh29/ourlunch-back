package pe.oh29oh29.ourlunch.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.entity.Family;
import pe.oh29oh29.ourlunch.entity.Restaurant;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.repository.RestaurantRepository;

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
