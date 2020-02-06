package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;

public class RestaurantCommand {

    @Getter
    public static class Addition {
        private String familyName;
        private String name;
        private String address;
        private String type;
        private String positionX;
        private String positionY;
    }
}
