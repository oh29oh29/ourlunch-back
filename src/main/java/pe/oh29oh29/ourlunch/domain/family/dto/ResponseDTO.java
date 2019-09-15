package pe.oh29oh29.ourlunch.domain.family.dto;

import lombok.Builder;

public class ResponseDTO {

    @Builder
    public static class Creation {
        private String linkUrl;
    }

    @Builder
    public static class Join {

    }
}
