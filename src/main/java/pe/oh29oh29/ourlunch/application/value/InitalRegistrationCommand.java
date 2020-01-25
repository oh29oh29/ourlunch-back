package pe.oh29oh29.ourlunch.application.value;

import lombok.Getter;

public class InitalRegistrationCommand {

    @Getter
    public static class Regist {
        private String userName;
        private String appetite;
        private String companyName;
        private String familyName;
    }
}
