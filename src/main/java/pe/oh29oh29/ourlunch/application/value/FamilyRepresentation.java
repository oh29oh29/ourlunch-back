package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;

public class FamilyRepresentation {

    @Builder
    @Getter
    public static class Creations {
        private String linkUrl;
    }
}
