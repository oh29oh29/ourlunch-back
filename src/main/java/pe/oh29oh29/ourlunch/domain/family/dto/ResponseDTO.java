package pe.oh29oh29.ourlunch.domain.family.dto;

import lombok.Builder;
import lombok.Getter;

public class ResponseDTO {

    @Builder
    @Getter
    public static class Creations {
        private String linkUrl;
    }


}
