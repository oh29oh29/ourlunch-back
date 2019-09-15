package pe.oh29oh29.ourlunch.domain.family.dto;

import lombok.Getter;
import lombok.Setter;

public class RequestDTO {

    @Getter
    @Setter
    public static class Creation {
        private String companyName;
        private String familyName;
    }

    @Getter
    @Setter
    public static class Join {

    }
}
