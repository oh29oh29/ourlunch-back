package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class MemberRepresentation {

    @Builder
    public static class Join {

    }

    @Builder
    @Getter
    public static class Profile {
        private String name;
        private String appetite;
        private Family family;
        private boolean isMaster;
        private String signUpDate;

        @Getter
        @Setter
        public static class Family {
            private Long id;
            private String name;
            private String code;
        }
    }
}
