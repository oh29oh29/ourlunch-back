package pe.oh29oh29.ourlunch.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.oh29oh29.ourlunch.application.MemberCommandService;
import pe.oh29oh29.ourlunch.application.MemberQueryService;
import pe.oh29oh29.ourlunch.constants.Common;

import java.util.Map;

@RequiredArgsConstructor

@Profile("!dev")
@Controller
public class OAuth2Controller {

    private final OAuth2AuthorizedClientService authorizedClientService;
    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;

    @GetMapping("/login/success")
    public String loginSuccess(OAuth2AuthenticationToken authentication) {
        final OAuth2AuthorizedClient oAuth2AuthorizedClient =
                authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName()
                );

        final String accessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();

        final OAuth2User user = authentication.getPrincipal();
        final Map userInfo = (Map) user.getAttributes().get("properties");
        final String id = user.getName();
        final String query = String.format("accessToken=%s", accessToken);

        if (!memberQueryService.exist(id)) {
            memberCommandService.signUp(id, (String) userInfo.get("nickname"));
            return Common.REDIRECT + "/home?" + query;
        } else {
            return Common.REDIRECT + "/main?" + query;
        }
    }
}
