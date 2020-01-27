package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
            value = "식당 등록 API",
            notes = "식당을 등록합니다."
    )
    @PostMapping
    public Response addRestaurant(
            @Valid @RequestBody final RestaurantCommand.Addition command
    ) {
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
    @ApiOperation(
            value = "식당 목록 조회 API",
            notes = "식당 목록을 조회합니다."
    )
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
