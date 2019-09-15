package pe.oh29oh29.ourlunch.domain.restaurant.dto;

import lombok.Getter;
import lombok.Setter;

public class RequestDTO {

    @Getter
    @Setter
    public static class Addition {
        private String familyName;
        private String restaurantName;
        private String positionX;
        private String positionY;
    }
}
