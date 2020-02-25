package pe.oh29oh29.ourlunch.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.oh29oh29.ourlunch.application.MemberCommandService;
import pe.oh29oh29.ourlunch.application.MemberQueryService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor

@Controller
public class OAuth2Controller {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final OAuth2AuthorizedClientService authorizedClientService;

    @PostConstruct
    public void init() {
        memberCommandService.signUp("1", "테스트계정");
    }

    @GetMapping("/login/success")
    public void loginSuccess(
            final HttpServletResponse response,
            final OAuth2AuthenticationToken authentication
    ) throws IOException {

        final OAuth2AuthorizedClient oAuth2AuthorizedClient =
                authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName()
                );

        final String accessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();

        final OAuth2User user = authentication.getPrincipal();
        final Map userInfo = (Map) user.getAttributes().get("properties");
        final String id = user.getName();

        response.getWriter().write(accessToken);

        if (!memberQueryService.exist((id))) {
            memberCommandService.signUp(id, (String) userInfo.get("nickname"));
            response.sendRedirect("/startFamily");
        } else {
            response.sendRedirect("/main");
        }
    }
}
