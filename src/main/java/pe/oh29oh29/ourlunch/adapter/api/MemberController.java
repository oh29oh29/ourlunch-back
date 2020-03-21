package pe.oh29oh29.ourlunch.adapter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.MemberQueryService;
import pe.oh29oh29.ourlunch.application.value.MemberRepresentation;
import pe.oh29oh29.ourlunch.constants.DateFormat;
import pe.oh29oh29.ourlunch.domain.family.Family;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.model.Response;
import pe.oh29oh29.ourlunch.util.DateUtil;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberQueryService memberQueryService;

    /**
     * 사용자 프로필 조회 API
     * */
    @GetMapping("/profile")
    public Response<MemberRepresentation.Profile> getMemberProfile(OAuth2AuthenticationToken authentication) {
        final OAuth2User user = authentication.getPrincipal();
        final String id = user.getName();
        final Member member = memberQueryService.findById(id);
        final Family family = member.getFamily();
        Long familyId = null;
        String familyName = null;

        if (family != null) {
            familyId = family.getId();
            familyName = family.getName();
        }

        return new Response<>(
                MemberRepresentation.Profile
                        .builder()
                        .name(member.getName())
                        .familyId(familyId)
                        .familyName(familyName)
                        .appetite(member.getAppetite())
                        .isMaster(member.isMaster())
                        .signUpDate(DateUtil.format(member.getSignUpDate(), DateFormat.yyyyMMddHHmmss))
                        .build()
        );
    }
}
