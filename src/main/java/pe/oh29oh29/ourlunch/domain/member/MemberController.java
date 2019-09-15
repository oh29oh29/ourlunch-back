package pe.oh29oh29.ourlunch.domain.member;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.oh29oh29.ourlunch.model.Response;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor

@RestController
public class MemberController {

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
