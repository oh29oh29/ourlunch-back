package pe.oh29oh29.ourlunch.application.value;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class FamilyRepresentation {

    @Builder
    @Getter
    public static class Creations {
        private String linkUrl;
    }

    @Builder
    @Getter
    public static class GetMembers {
        private List<Member> members;

        @Builder
        @Getter
        public static class Member {
            private String id;
            private String name;
            private String appetite;
        }
    }
}
