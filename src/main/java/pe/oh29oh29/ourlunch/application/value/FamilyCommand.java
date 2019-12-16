package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;
import lombok.Setter;

public class FamilyCommand {

    @Getter
    @Setter
    public static class Creation {
        private String companyName;
        private String familyName;
    }
}
