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

    @Data
    public static class FamilyJoinRequest {
        private String memberName;
        private String taste;
    }

    @Data
    public static class FamilyMembersSelectRequest {
        private String familyId;
    }

    @Data
    public static class RestaurantCreationRequest {
        private String familyId;
        private String name;
        private String type;
        private String placeId;

    }
}
