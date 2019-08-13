package pe.oh29oh29.ourlunch.domain.restaurant.dto;

import lombok.Data;

public class RequestDTO {

    @Data
    public static class RestaurantCreationRequest {
        private String familyId;
        private String name;
        private String type;
        private String placeId;

    }
}
