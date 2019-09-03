package pe.oh29oh29.ourlunch.domain.restaurant;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @ApiOperation(
        value = "식당 등록 API",
        notes = "식당을 등록합니다."
    )
    @PostMapping("")
    public RestaurantDTO.Addition.Res addRestaurant(@RequestBody RestaurantDTO.Addition.Req request) {
        restaurantService.addRestaurant(request.getFamilyName(), request.getRestaurantName(), request.getPositionX(), request.getPositionY());
        return RestaurantDTO.Addition.Res.builder().build();
    }

}
