package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;

public class MemberRepresentation {

    @Builder
    public static class Join {

    }

    @Builder
    @Getter
    public static class Profile {
        private String name;
        private Long familyId;
        private String familyName;
        private String appetite;
        private boolean isMaster;
        private String signUpDate;
    }
}
