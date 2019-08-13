package pe.oh29oh29.ourlunch.domain.family.dto;

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

    @Data
    public static class FamilyJoinRequest {
        private String memberName;
        private String taste;
    }
}
