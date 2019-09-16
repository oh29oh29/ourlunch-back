package pe.oh29oh29.ourlunch.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pe.oh29oh29.ourlunch.domain.member.MemberService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor

@Controller
public class OAuth2Controller {

    private final MemberService memberService;

    @PostConstruct
    public void init() {
        memberService.signUp("1", "테스트계정");
    }

    @GetMapping("/login/success")
    public void loginSuccess(final HttpServletResponse response, final OAuth2AuthenticationToken authentication) throws IOException {

        String nextStep = "/startFamily";

        final OAuth2User user = authentication.getPrincipal();
        final Map userInfo = (Map) user.getAttributes().get("properties");
        final String id = user.getName();

        if (memberService.exist(id)) {
            nextStep = "/main";
        } else {
            final String nickName = (String) userInfo.get("nickname");
            memberService.signUp(id, nickName);
        }

        response.sendRedirect(nextStep);
    }
}
