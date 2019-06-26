package pe.oh29oh29.ourlunch.model;

import lombok.Data;

public class RequestDTO {

    @Data
    public static class FamilyCreationRequest {
        private String companyName;
        private String memberId;
        private String memberName;
        private String memberPassword;
        private String familyName;
    }
}
