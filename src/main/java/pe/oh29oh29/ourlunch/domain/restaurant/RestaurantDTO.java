package pe.oh29oh29.ourlunch.domain.restaurant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class RestaurantDTO {

    static class Addition {

        @Getter
        @Setter
        static class Req {
            private String familyName;
            private String restaurantName;
            private String positionX;
            private String positionY;
        }

        @Builder
        static class Res {
        }

    }
}
