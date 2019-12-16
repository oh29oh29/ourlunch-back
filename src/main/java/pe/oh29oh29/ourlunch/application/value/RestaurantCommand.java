package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;
import lombok.Setter;

public class RestaurantCommand {

    @Getter
    @Setter
    public static class Addition {
        private String familyName;
        private String restaurantName;
        private String positionX;
        private String positionY;
    }
}
