package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class FamilyCommand {

    @Getter
    public static class Create {
        private String userName;
        private String appetite;
        private String companyName;
        private String familyName;
    }

    @Getter
    public static class Join {
        @NotBlank
        private String familyCode;  // 팸 코드
        @NotBlank
        private String name;        // 멤버 이름
        @NotBlank
        private String appetite;    // 멤버 입맛
    }
}
