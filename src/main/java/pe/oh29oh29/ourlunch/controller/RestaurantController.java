package pe.oh29oh29.ourlunch.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.model.RequestDTO;
import pe.oh29oh29.ourlunch.model.ResponseDTO;
import pe.oh29oh29.ourlunch.service.RestaurantService;

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
    public ResponseDTO addRestaurant(@RequestBody RequestDTO.RestaurantCreationRequest request) {
        restaurantService.addRestaurant(request);
        return new ResponseDTO();
    }


}
