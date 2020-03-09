package pe.oh29oh29.ourlunch.adapter_dev;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.adapter.api.MemberController;
import pe.oh29oh29.ourlunch.application.value.MemberRepresentation;
import pe.oh29oh29.ourlunch.model.Response;

@RequiredArgsConstructor

@Profile("dev")
@RestController
@RequestMapping("/dev/api/v1/member")
public class DevMemberController {

    private final DevOAuth2AuthenticationToken devOAuth2AuthenticationToken;
    private final MemberController memberController;

    @GetMapping("/profile")
    public Response<MemberRepresentation.Profile> getMemberProfile() {
        return memberController.getMemberProfile(devOAuth2AuthenticationToken.getAuthentication());
    }
}
