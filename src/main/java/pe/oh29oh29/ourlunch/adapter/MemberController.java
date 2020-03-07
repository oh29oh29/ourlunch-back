package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.application.MemberQueryService;
import pe.oh29oh29.ourlunch.application.value.MemberRepresentation;
import pe.oh29oh29.ourlunch.domain.member.Member;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/profile")
    public Response<MemberRepresentation.Profile> getMemberProfile(final OAuth2AuthenticationToken authentication) {
        final OAuth2User user = authentication.getPrincipal();
        final String id = user.getName();

        final Member member = memberQueryService.findById(id);

        return new Response<>(
                MemberRepresentation.Profile
                        .builder()
                        .name(member.getName())
                        .familyName(member.getFamily().getName())
                        .appetite(member.getAppetite())
                        .isMaster(member.isMaster())
                        .signUpDate(member.getSignUpDate())
                        .build()
        );
    }
}
