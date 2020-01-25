package pe.oh29oh29.ourlunch.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.oh29oh29.ourlunch.domain.family.FamilyRepository;
import pe.oh29oh29.ourlunch.domain.restaurant.RestaurantRepository;

@RequiredArgsConstructor

@Service
public class RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final FamilyRepository familyRepository;

}
