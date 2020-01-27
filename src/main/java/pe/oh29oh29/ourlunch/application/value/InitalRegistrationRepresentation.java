package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;

public class InitalRegistrationRepresentation {

    @Builder
    @Getter
    public static class Regist {
        private String linkUrl;
    }
}
