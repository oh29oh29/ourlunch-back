package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.oh29oh29.ourlunch.application.MemberCommandService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor

@Controller
@RequestMapping("/login")
public class LoginController {

    private final MemberCommandService memberCommandService;

    private final OAuth2AuthorizedClientService authorizedClientService;

    @PostConstruct
    public void init() {
        memberCommandService.signUp("1", "테스트계정");
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping("/success")
    public void loginSuccess(final HttpServletResponse response, final OAuth2AuthenticationToken authentication) throws IOException {

        OAuth2AuthorizedClient oAuth2AuthorizedClient = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        OAuth2AccessToken accessToken = oAuth2AuthorizedClient.getAccessToken();

        String nextStep = "/startFamily";

        final OAuth2User user = authentication.getPrincipal();
        final Map userInfo = (Map) user.getAttributes().get("properties");
        final String id = user.getName();

        if (memberCommandService.exist(id)) {
            nextStep = "/main";
        } else {
            final String nickName = (String) userInfo.get("nickname");
            memberCommandService.signUp(id, nickName);
        }

        response.getWriter().write(accessToken.getTokenValue());
        response.sendRedirect(nextStep);
    }
}
