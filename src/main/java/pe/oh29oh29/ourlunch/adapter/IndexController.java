package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.oh29oh29.ourlunch.application.MemberQueryService;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor

@Controller
public class IndexController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/")
    public String welcome(OAuth2AuthenticationToken authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        final OAuth2User user = authentication.getPrincipal();
        final String id = user.getName();

        if (!memberQueryService.exist((id))) {
            return "redirect:/startFamily";
        } else {
            return "redirect:/main";
        }
    }

    @GetMapping("/redirect")
    public String goHome(OAuth2AuthenticationToken authentication) {
        if (authentication.isAuthenticated()) {
            return "redirect:/login/success";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/join")
    public String forwardJoinIndexPage(
            @RequestParam("family_code") String familyCode,
            HttpServletRequest request
    ) {
        request.setAttribute("family_code", familyCode);
        return "forward:/index.html";
    }

    @GetMapping(value = {"/{path:[^\\\\.]*}", "/**/{path:[^\\\\.]*}"})
    public String html5Forwarding(
            @RequestParam(value = "access_token", required = false) String accessToken,
            HttpServletRequest request
    ) {
        request.setAttribute("access_token", accessToken);
        return "forward:/index.html";
    }
}
