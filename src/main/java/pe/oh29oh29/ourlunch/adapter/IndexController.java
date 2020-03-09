package pe.oh29oh29.ourlunch.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.oh29oh29.ourlunch.application.MemberQueryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


    @RequestMapping(value = {"/{path:[^\\\\.]*}", "/**/{path:[^\\\\.]*}"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String html5Forwarding(
            @RequestParam(value = "access_token", required = false) String accessToken,
            HttpServletRequest request
    ) {
        request.setAttribute("access_token", accessToken);
        return "forward:/index.html";
    }

    @GetMapping("/redirect")
    public void goHome(
            HttpServletResponse response,
            OAuth2AuthenticationToken authentication
    ) throws IOException {
        if (authentication.isAuthenticated()) {
            response.sendRedirect("/login/success");
        } else {
            response.sendRedirect("/login");
        }
    }
}
