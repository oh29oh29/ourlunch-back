package pe.oh29oh29.ourlunch.adapter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.RestaurantCommandService;
import pe.oh29oh29.ourlunch.application.value.RestaurantCommand;
import pe.oh29oh29.ourlunch.application.value.RestaurantRepresentation;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantCommandService restaurantCommandService;

    @ApiOperation(
            value = "식당 등록 API",
            notes = "식당을 등록합니다."
    )
    @PostMapping
    public Response<RestaurantRepresentation.Addition> addRestaurant(
            @RequestBody final RestaurantCommand.Addition command
    ) {
        restaurantCommandService.addRestaurant(
                command.getFamilyName(),
                command.getRestaurantName()
        );
        return new Response<>(
                RestaurantRepresentation.Addition
                        .builder()
                        .build()
        );
    }

}
