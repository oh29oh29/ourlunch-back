package pe.oh29oh29.ourlunch.domain.family;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

class FamilyDTO {

    static class Creation {

        @Getter
        @Setter
        static class Req {
            private String familyName;
        }

        @Builder
        static class Res {
            private String linkUrl;
        }

    }

    static class Join {

        @Getter
        @Setter
        static class Req {

        }

        @Builder
        static class Res {

        }
    }
}
