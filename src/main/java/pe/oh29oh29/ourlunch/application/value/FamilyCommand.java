package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;
import lombok.Setter;
import pe.oh29oh29.ourlunch.domain.company.Company;

public class FamilyCommand {

    @Getter
    @Setter
    public static class Creation {
        private String familyName;
        private Company company;
    }
}
