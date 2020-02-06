package pe.oh29oh29.ourlunch.domain.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.oh29oh29.ourlunch.domain.family.Family;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByFamily(Family family);

}
