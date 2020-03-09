package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.oh29oh29.ourlunch.application.RestaurantCommandService;
import pe.oh29oh29.ourlunch.application.RestaurantQueryService;
import pe.oh29oh29.ourlunch.application.value.RestaurantCommand;
import pe.oh29oh29.ourlunch.application.value.RestaurantRepresentation;
import pe.oh29oh29.ourlunch.domain.restaurant.Restaurant;
import pe.oh29oh29.ourlunch.model.Response;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;

    @PostMapping
    public Response addRestaurant(@Valid @RequestBody RestaurantCommand.Addition command) {
        restaurantCommandService.addRestaurant(
                command.getFamilyName(),
                command.getName(),
                command.getAddress(),
                command.getType(),
                command.getPositionX(),
                command.getPositionY()
        );
        return Response.ok();
    }

    /**
     * TODO
     * 페이징
     * */
    @GetMapping("/list")
    public Response<RestaurantRepresentation.Total> getRestaurants(@RequestParam("family_name") String familyName) {
        final List<Restaurant> restaurants = restaurantQueryService.findAllByFamilyName(familyName);
        final List<RestaurantRepresentation.Total.Unit> units = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            units.add(
                    RestaurantRepresentation.Total.Unit
                            .builder()
                            .name(restaurant.getName())
                            .type(restaurant.getType())
                            .build()
            );
        }

        return new Response<>(
                RestaurantRepresentation.Total
                        .builder()
                        .restaurants(units)
                        .build()
        );
    }
}
