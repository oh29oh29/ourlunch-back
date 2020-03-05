package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberRepresentation {

    @Builder
    public static class Join {

    }

    @Builder
    public static class Profile {
        private String name;
        private String familyName;
        private String appetite;
        private boolean isMaster;
        private LocalDateTime signUpDate;
    }
}
