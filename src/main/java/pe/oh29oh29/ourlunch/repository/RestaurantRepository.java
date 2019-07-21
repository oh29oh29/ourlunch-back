package pe.oh29oh29.ourlunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.oh29oh29.ourlunch.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
