package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class RestaurantRepresentation {

    @Builder
    @Getter
    public static class Addition {

    }

    @Builder
    @Getter
    public static class Total {
        private List<Unit> restaurants;

        @Builder
        @Getter
        public static class Unit {
            private String name;
            // TODO 나중에 enum으로 변경??
            private String type;
        }
    }

}
