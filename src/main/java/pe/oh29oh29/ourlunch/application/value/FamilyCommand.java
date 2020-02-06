package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;
import lombok.Setter;
import pe.oh29oh29.ourlunch.domain.company.Company;

import javax.validation.constraints.NotBlank;

public class FamilyCommand {

    @Getter
    @Setter
    public static class Creation {

        @NotBlank
        private String familyName;  // 팸 이름
        @NotBlank
        private Company company;    // 소속 회사
    }
}
