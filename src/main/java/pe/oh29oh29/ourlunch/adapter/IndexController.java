package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.oh29oh29.ourlunch.application.MemberCommandService;
import pe.oh29oh29.ourlunch.application.MemberQueryService;
import pe.oh29oh29.ourlunch.constants.Common;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequiredArgsConstructor

@Controller
public class IndexController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("/")
    public String welcome(OAuth2AuthenticationToken authentication) {
        if (authentication == null) {
            return Common.REDIRECT + "/";
        }

        final OAuth2User user = authentication.getPrincipal();
        final Map userInfo = (Map) user.getAttributes().get("properties");
        final String id = user.getName();

        if (!memberQueryService.exist(id)) {
            memberCommandService.signUp(id, (String) userInfo.get("nickname"));
            return Common.REDIRECT + "/home";
        } else {
            return Common.REDIRECT + "/main";
        }
    }

    @GetMapping(value = {"/{path:[^\\\\.]*}", "/**/{path:[^\\\\.]*}"})
    public String html5Forwarding(
            @RequestParam(value = "access_token", required = false) String accessToken,
            HttpServletRequest request
    ) {
        request.setAttribute("accessToken", accessToken);
        return Common.FORWARD + "/index.html";
    }
}
