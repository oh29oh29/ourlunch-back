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
public class RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;
    private final FamilyRepository familyRepository;

    public List<Restaurant> findAllByFamilyName(String familyName) {
        final Family family = familyRepository.findByName(familyName).orElseThrow(IllegalArgumentException::new);
        return restaurantRepository.findAllByFamily(family);
    }

}
